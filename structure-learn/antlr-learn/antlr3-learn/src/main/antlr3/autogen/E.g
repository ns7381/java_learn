grammar E;
options { output=AST; }
@header {
package autogen;
}
@lexer::header {
package autogen;
}
expression : multExpr (('+' |'-' ) multExpr)*;
multExpr : atom (('*' | '/') atom)*;
atom : INT | '(' expression ')';
INT : '0'..'9' + ;
WS : (' ' |'\t' |'\n' |'\r' )+ {skip();};