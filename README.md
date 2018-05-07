# Micro-Compiler is a scanner-parser for primitive programing language
It depends on JCup and JFlex libraries

## Build
1. Run build.bat script
2. Build Project

## Task
### 1. Wstęp Zadanie polega na stworzeniu kompilatora prostego języka do kodu maszyny stosowej. 
### 2. Gramatyka języka źródłowego Język składa się z wyrażeń arytmetycznych na liczbach całkowitych, wyrażeń logicznych, przypisań oraz konstrukcji if (dwie wersje) i while (też dwie wersje). 
Oznaczenia: 
- NUM - liczby całkowite ze znakiem, zakres zgodny z typem signed long long int (64 bity) 
- IDENT - identyfikator zmiennej (string, nazewnictwo identyfikatorów standardowe) 
- Pozostałe słowa kluczowe: and, or, not, if, then, else, while, do, print, read, begin, end, exit. 
- Operatory arytmetyczne 
  ```num_op = "+" | "-" | "*" | "/" | "%"``` 
- Wyrażenie "numeryczne", którego wartością jest liczba 
  ```num_expr = NUM | "-" NUM | "+" NUM | IDENT | num_expr num_op num_expr | "(" num_expr ")"```
- Operatory logiczne 
  ```bool_op = "and" | "or" *** relacje logiczne rel = "=" | "<" | "<=" | ">" | ">=" | "<>"
  bool_expr = "true" | "false" | "(" bool_expr ")" | "not" bool_expr | bool_expr bool_op bool_expr | num_expr rel num_expr```
- Podstawowe konstrukcje 
  ```simple_instr = assign_stat | if_stat | while_stat | "begin" instr "end" | output_stat | input_stat | "exit"```
- Ciąg instrukcji 
  ```instr = instr simple_instr ";" | simple_instr ";"```
- Przypisanie 
  ```assign_stat = IDENT ":=" num_expr```
- Konstrukcja warunkowa 
  ```if_stat = "if" bool_expr "then" simple_instr | "if" bool_expr "then" simple_instr "else" simple_instr```
- Petla "while" 
  ```while_stat = "while" bool_expr "do" simple_instr | "do" simple_instr "while" bool_expr```
- Wypisanie informacji na ekran 
  ```output_stat = "print" num_expr```
- Wczytanie informacji do zmiennej
  ```input_stat = "read" IDENT```
- Program jako taki 
  ```program = instr```
Dodatkowe objaśnienia: 
- Jest tylko jeden typ zmiennych – liczby całkowite ze znakiem, z precyzją odpowiadającą typowi signed long long int.
- Instrukcja print powoduje wypisanie na wyjście (ekran) liczby będącej wynikiem wyrażenia.
- Instrukcja read służy o wczytywania z wejścia (klawiatury) zawartości pod zadaną zmienną.
- Instrukcja exit powoduje bezwarunkowe zakończenie działania programu.
- Konstrukcje if...then, if...then...else, while...do oraz do...while działają w sposób standardowy.
- Konstrukcja begin...end służy do grupowania instrukcji prostych. 
### 3. Język docelowy Docelowym językiem jest język maszyny stosowej. 
Maszyna dysponuje:
- Pamięcią na program, adresowaną od adresu $0 (adresy podaje się poprzedzając je znakiem $), od której to komórki rozpoczyna się wykonanie programu). Pod jednym adresem musi się znajdować dokładnie jedna instrukcja maszyny stosowej. Jeśli program podczas wykonania napotka adres bez żadnej instrukcji, maszyna zatrzymuje się z błędem.
- Osobnym blokiem pamięci na dane, służącej do przechowywania zawartości zmiennych, adresowaną również od $0, ale w obrębie tej pamięci. Poszczególne zmienne globalne programu powinny zostać odwzorowane na tą pamięć w takcie kompilacji programu. Pamięć ta jest stałego rozmiaru w trakcie wykonania programu. Zakłada się, że pod jednym adresem mieści się zawartość jednej zmiennej.
- Stosem operacyjnym, za pomocą którego wykonywane są operacje. Początkowo stos jest pusty. Próba zdjęcia wartości z pustego stosu lub wykonanie operacji wymagającej obecności czegokolwiek na stosie powoduje błąd i zatrzymanie maszyny.
Maszyna posiada następujące instrukcje:
Operacje główne na stosie: 
- PUSH $ADR - powoduje włożenie na stos zawartości pamięci danych spod zadanego adresu. Odwołanie do adresu, który nie został "zaplanowany" podczas kompilacji, powoduje błąd i zatrzymanie maszyny.
- PUSH VAL - powoduje włożenie na stos stałej zadanej jako parametr.
- POP $ADR - powoduje zdjęcie wartości ze szczytu stosu i zapamiętanie jej pod komórką pamięci określoną przez podany adres. Odwołanie do adresu poza blokiem pamięci na dane powoduje błąd i zatrzymanie maszyny.
- POP - oznacza od zdjęcie wartości ze stosu bez zapamiętywania jej (czyszczenie stosu).
- DUP - powoduje zdjęcie wartości na szczycie stosu i ponowne DWUKROTNE włożenie jej (przydatne, gdy np. chcemy wypisać coś bez modyfikowania zawartości stosu).
Operatory arytmetyczne:
- ADD - powoduje zdjęcie ze stosu dwóch wartości, wyliczenie ich sumy i odłożenie na stos wyniku tej operacji. Przepełnienie nie powoduje błędu.
- MUL - powoduje zdjęcie ze stosu dwóch wartości, wyliczenie ich iloczynu i odłożenie na stos wyniku tej operacji. Przepełnienie nie powoduje błędu.
- DIV - powoduje zdjęcie ze stosu dwóch wartości, wyliczenie ich ilorazu całkowitoliczbowego (wartość druga / wartość pierwsza, licząc od szczytu stosu) i odłożenie na stos wyniku tej operacji. Dzielenie przez 0 powoduje wygenerowanie błędu i zatrzymanie działania maszyny.
- NEG - powoduje zdjęcie wartości ze stosu, zanegowanie jej i odłożenie na stos wyniku tej operacji.
Skoki (każdorazowo, skok pod niepoprawny adres powoduje błąd i zatrzymanie działania maszyny):
- JMP $ADR - powoduje bezwarunkowy skok pod podany adres (w obrębie pamięci programu).
- JZ $ADR - powoduje zdjęcie wartości ze szczytu stosu i skok pod zadany adres, jeśli ta wartość jest równa 0. Jeśli wartość jest niezerowa, instrukcja nie powoduje innego efektu.
- JNZ $ADR - powoduje zdjęcie wartości ze szczytu stosu i skok pod zadany adres, jeśli ta wartość jest nierówna 0. Jeśli wartość jest zerowa, instrukcja nie powoduje innego efektu. 
- JLZ $ADR -  powoduje zdjęcie wartości ze szczytu stosu i skok pod zadany adres, jeśli ta wartość jest ujemna. Jeśli wartość jest nieujemna, instrukcja nie powoduje innego efektu.
- JLEZ $ADR -  powoduje zdjęcie wartości ze szczytu stosu i skok pod zadany adres, jeśli ta wartość jest ujemna lub zerowa. Jeśli wartość jest dodatnia, instrukcja nie powoduje innego efektu. 
- JGZ $ADR -  powoduje zdjęcie wartości ze szczytu stosu i skok pod zadany adres, jeśli ta wartość jest dodatnia. Jeśli wartość jest mniejsza lub równa 0, instrukcja nie powoduje innego efektu. 
- JGEZ $ADR -  powoduje zdjęcie wartości ze szczytu stosu i skok pod zadany adres, jeśli ta wartość jest nieujemna. Jeśli wartość jest mniejsza od 0, instrukcja nie powoduje innego efektu.
Inne instrukcje:
- READ - powoduje wczytanie wartości z klawiatury (wejścia) i zapisanie jej na szczycie stosu.
- PRINT - powoduje zdjęcie zawartości ze szczytu stosu i wypisanie jej na ekranie (wyjściu).
- STOP - powoduje zakończenie działania programu i poprawne zatrzymanie maszyny.
- NOP - nie powoduje żadnego efektu (pusta instrukcja). 

#### Format pliku z programem dla maszyny docelowej: 
Wszystkie ciągi znaków po znaku # do końca linii oraz wiesze puste są pomijane.
Pierwszy znaczący wiersz programu może mieć postać: DATA val1, val2, val3, ... valN Oznacza on początkową zawartość pamięci danych. Wyliczone w tym wierszu wartości zostaną załadowane pod kolejne komórki pamięci danych, jednocześnie określając rozmiar tej pamięci. Jeśli wiersza tego nie ma, zakłada się, że nie będzie wykorzystywana żadna pamięć danych.
Wiersze zawierające instrukcje rozpoczynają się od liczby określającej adres, pod który dana instrukcja ma zostać załadowana w pamięci programu.
### 4. Zadanie 
Za pomocą fleksa, bisona dla C/C++ (lub odpowiadających im narzędzi dla innych języków programowania) należy napisać program, który będzie dokonywał translacji z języka opisanego powyższą gramatyką na kod dla maszyny stosowej (uwzględniając powyższe uwagi). Dane wejściowe (kod źródłowy do kompilacji) będą podawane na standardowe wejście tego programu. Wyjście (kod skompilowany) powinno się pojawić albo na standardowym wyjściu (ekran) albo w pliku - do wyboru, jak kto woli zrobić.
