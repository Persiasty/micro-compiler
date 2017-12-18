@echo off
java -Xmx128m -jar lib\jflex\lib\jflex-1.6.1.jar src/Lexer.flex
java -cp lib/jcup/java-cup-11b.jar java_cup.Main -destdir src -parser Parser -symbols Symbols < src/Parser.cup