@echo off
java -Xmx128m -jar lib\jflex\lib\jflex-1.6.1.jar src/main/java/Lexer.flex
java -cp lib/jcup/java-cup-11b.jar java_cup.Main -destdir src/main/java -parser Parser -symbols Symbols < src/main/java/Parser.cup