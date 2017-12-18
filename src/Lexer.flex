import java_cup.runtime.*;

%%

%class Lexer

%line
%column

%cup

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

%eofval{
    new java_cup.runtime.Symbol(Symbols.EOF);
%eofval}


LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

NUM = [0-9]+
IDENT = [A-Za-z_][A-Za-z_0-9]*

%%

<YYINITIAL> {

    /** Keywords. */
    "and"             { return symbol(Symbols.AND); }
    "or"              { return symbol(Symbols.OR); }
    "not"             { return symbol(Symbols.NOT); }
    "true"             { return symbol(Symbols.TRUE); }
    "false"             { return symbol(Symbols.FALSE); }

    "begin"           { return symbol(Symbols.BEGIN); }
    "end"             { return symbol(Symbols.END); }
    "exit"            { return symbol(Symbols.EXIT); }
    "if"              { return symbol(Symbols.IF); }
    "then"            { return symbol(Symbols.THEN); }
    "else"            { return symbol(Symbols.ELSE); }
    "while"           { return symbol(Symbols.WHILE); }
    "do"              { return symbol(Symbols.DO); }

    "print"           { return symbol(Symbols.PRINT); }
    "read"         { return symbol(Symbols.READ); }

    ":="              {return symbol(Symbols.ASSIGN); }
    "="               { return symbol(Symbols.EQ); }
    "<"               { return symbol(Symbols.LT); }
    "<="              { return symbol(Symbols.LE); }
    ">"               { return symbol(Symbols.GT); }
    ">="              { return symbol(Symbols.GE); }
    "<>"              { return symbol(Symbols.NE); }

    ";"                { return symbol(Symbols.SEMI); }
    "("                { return symbol(Symbols.LPAREN); }
    ")"                { return symbol(Symbols.RPAREN); }
    "+"                { return symbol(Symbols.PLUS); }
    "-"                { return symbol(Symbols.MINUS); }
    "*"                { return symbol(Symbols.TIMES); }
    "%"                { return symbol(Symbols.MODE);  }
    "/"                { return symbol(Symbols.DIVIDE); }

    {NUM}      { return symbol(Symbols.NUM, new Integer(yytext())); }
    {IDENT}       { return symbol(Symbols.IDENT, new String(yytext()));}

    {WhiteSpace}       { /* do nothing */ }
    <<EOF>> { return symbol(Symbols.EOF); }
}


/* error */
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }