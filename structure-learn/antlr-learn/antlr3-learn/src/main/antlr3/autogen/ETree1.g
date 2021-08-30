grammar ETree1;
options { output=AST; }
expression : multExpr (('+'^ |'-'^ ) multExpr)*;
multExpr : atom (('*'^ | '/'^) atom)*;
atom : INT | '('! expression ')'!;
INT : '0'..'9' + ;
WS : (' ' |'\t' |'\n' |'\r' )+ {skip();};