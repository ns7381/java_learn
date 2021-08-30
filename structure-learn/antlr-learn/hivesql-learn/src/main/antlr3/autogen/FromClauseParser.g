/**
   Licensed to the Apache Software Foundation (ASF) under one or more 
   contributor license agreements.  See the NOTICE file distributed with 
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with 
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
parser grammar FromClauseParser;

options
{
output=AST;
ASTLabelType=CommonTree;
backtrack=false;
k=3;
}

@members {
  @Override
  public Object recoverFromMismatchedSet(IntStream input,
      RecognitionException re, BitSet follow) throws RecognitionException {
    throw re;
  }
  @Override
  public void displayRecognitionError(String[] tokenNames,
      RecognitionException e) {
    gHiveParser.errors.add(new ParseError(gHiveParser, e, tokenNames));
  }
}

@rulecatch {
catch (RecognitionException e) {
  throw e;
}
}

//-----------------------------------------------------------------------------------

tableAllColumns
    : STAR
        -> ^(TOK_ALLCOLREF)
    | tableName DOT STAR
        -> ^(TOK_ALLCOLREF tableName)
    ;

// (table|column)
tableOrColumn
@init { gHiveParser.pushMsg("table or column identifier", state); }
@after { gHiveParser.popMsg(state); }
    :
    identifier -> ^(TOK_TABLE_OR_COL identifier)
    ;

expressionList
@init { gHiveParser.pushMsg("expression list", state); }
@after { gHiveParser.popMsg(state); }
    :
    expression (COMMA expression)* -> ^(TOK_EXPLIST expression+)
    ;

aliasList
@init { gHiveParser.pushMsg("alias list", state); }
@after { gHiveParser.popMsg(state); }
    :
    identifier (COMMA identifier)* -> ^(TOK_ALIASLIST identifier+)
    ;

//----------------------- Rules for parsing fromClause ------------------------------
// from [col1, col2, col3] table1, [col4, col5] table2
fromClause
@init { gHiveParser.pushMsg("from clause", state); }
@after { gHiveParser.popMsg(state); }
    :
    KW_FROM joinSource -> ^(TOK_FROM joinSource)
    ;

joinSource
@init { gHiveParser.pushMsg("join source", state); }
@after { gHiveParser.popMsg(state); }
    : fromSource ( joinToken^ fromSource ( KW_ON! expression {$joinToken.start.getType() != COMMA}? )? )*
    | uniqueJoinToken^ uniqueJoinSource (COMMA! uniqueJoinSource)+
    ;

uniqueJoinSource
@init { gHiveParser.pushMsg("join source", state); }
@after { gHiveParser.popMsg(state); }
    : KW_PRESERVE? fromSource uniqueJoinExpr
    ;

uniqueJoinExpr
@init { gHiveParser.pushMsg("unique join expression list", state); }
@after { gHiveParser.popMsg(state); }
    : LPAREN e1+=expression (COMMA e1+=expression)* RPAREN
      -> ^(TOK_EXPLIST $e1*)
    ;

uniqueJoinToken
@init { gHiveParser.pushMsg("unique join", state); }
@after { gHiveParser.popMsg(state); }
    : KW_UNIQUEJOIN -> TOK_UNIQUEJOIN;

joinToken
@init { gHiveParser.pushMsg("join type specifier", state); }
@after { gHiveParser.popMsg(state); }
    :
      KW_JOIN                      -> TOK_JOIN
    | KW_INNER KW_JOIN             -> TOK_JOIN
    | COMMA                        -> TOK_JOIN
    | KW_CROSS KW_JOIN             -> TOK_CROSSJOIN
    | KW_LEFT  (KW_OUTER)? KW_JOIN -> TOK_LEFTOUTERJOIN
    | KW_RIGHT (KW_OUTER)? KW_JOIN -> TOK_RIGHTOUTERJOIN
    | KW_FULL  (KW_OUTER)? KW_JOIN -> TOK_FULLOUTERJOIN
    | KW_LEFT KW_SEMI KW_JOIN      -> TOK_LEFTSEMIJOIN
    ;

lateralView
@init {gHiveParser.pushMsg("lateral view", state); }
@after {gHiveParser.popMsg(state); }
	:
	(KW_LATERAL KW_VIEW KW_OUTER) => KW_LATERAL KW_VIEW KW_OUTER function tableAlias (KW_AS identifier ((COMMA)=> COMMA identifier)*)?
	-> ^(TOK_LATERAL_VIEW_OUTER ^(TOK_SELECT ^(TOK_SELEXPR function identifier* tableAlias)))
	|
	KW_LATERAL KW_VIEW function tableAlias (KW_AS identifier ((COMMA)=> COMMA identifier)*)?
	-> ^(TOK_LATERAL_VIEW ^(TOK_SELECT ^(TOK_SELEXPR function identifier* tableAlias)))
	;

tableAlias
@init {gHiveParser.pushMsg("table alias", state); }
@after {gHiveParser.popMsg(state); }
    :
    identifier -> ^(TOK_TABALIAS identifier)
    ;

fromSource
@init { gHiveParser.pushMsg("from source", state); }
@after { gHiveParser.popMsg(state); }
    :
    ((Identifier LPAREN)=> partitionedTableFunction | tableSource | subQuerySource | virtualTableSource) (lateralView^)*
    ;

tableBucketSample
@init { gHiveParser.pushMsg("table bucket sample specification", state); }
@after { gHiveParser.popMsg(state); }
    :
    KW_TABLESAMPLE LPAREN KW_BUCKET (numerator=Number) KW_OUT KW_OF (denominator=Number) (KW_ON expr+=expression (COMMA expr+=expression)*)? RPAREN -> ^(TOK_TABLEBUCKETSAMPLE $numerator $denominator $expr*)
    ;

splitSample
@init { gHiveParser.pushMsg("table split sample specification", state); }
@after { gHiveParser.popMsg(state); }
    :
    KW_TABLESAMPLE LPAREN  (numerator=Number) (percent=KW_PERCENT|KW_ROWS) RPAREN
    -> {percent != null}? ^(TOK_TABLESPLITSAMPLE TOK_PERCENT $numerator)
    -> ^(TOK_TABLESPLITSAMPLE TOK_ROWCOUNT $numerator)
    |
    KW_TABLESAMPLE LPAREN  (numerator=ByteLengthLiteral) RPAREN
    -> ^(TOK_TABLESPLITSAMPLE TOK_LENGTH $numerator)
    ;

tableSample
@init { gHiveParser.pushMsg("table sample specification", state); }
@after { gHiveParser.popMsg(state); }
    :
    tableBucketSample |
    splitSample
    ;

tableSource
@init { gHiveParser.pushMsg("table source", state); }
@after { gHiveParser.popMsg(state); }
    : tabname=tableName 
    ((tableProperties) => props=tableProperties)?
    ((tableSample) => ts=tableSample)? 
    ((KW_AS) => (KW_AS alias=Identifier) 
    |
    (Identifier) => (alias=Identifier))?
    -> ^(TOK_TABREF $tabname $props? $ts? $alias?)
    ;

tableName
@init { gHiveParser.pushMsg("table name", state); }
@after { gHiveParser.popMsg(state); }
    :
    db=identifier DOT tab=identifier
    -> ^(TOK_TABNAME $db $tab)
    |
    tab=identifier
    -> ^(TOK_TABNAME $tab)
    ;

viewName
@init { gHiveParser.pushMsg("view name", state); }
@after { gHiveParser.popMsg(state); }
    :
    (db=identifier DOT)? view=identifier
    -> ^(TOK_TABNAME $db? $view)
    ;

subQuerySource
@init { gHiveParser.pushMsg("subquery source", state); }
@after { gHiveParser.popMsg(state); }
    :
    LPAREN queryStatementExpression RPAREN KW_AS? identifier -> ^(TOK_SUBQUERY queryStatementExpression identifier)
    ;

//---------------------- Rules for parsing PTF clauses -----------------------------
partitioningSpec
@init { gHiveParser.pushMsg("partitioningSpec clause", state); }
@after { gHiveParser.popMsg(state); } 
   :
   partitionByClause orderByClause? -> ^(TOK_PARTITIONINGSPEC partitionByClause orderByClause?) |
   orderByClause -> ^(TOK_PARTITIONINGSPEC orderByClause) |
   distributeByClause sortByClause? -> ^(TOK_PARTITIONINGSPEC distributeByClause sortByClause?) |
   sortByClause -> ^(TOK_PARTITIONINGSPEC sortByClause) |
   clusterByClause -> ^(TOK_PARTITIONINGSPEC clusterByClause)
   ;

partitionTableFunctionSource
@init { gHiveParser.pushMsg("partitionTableFunctionSource clause", state); }
@after { gHiveParser.popMsg(state); } 
   :
   subQuerySource |
   tableSource |
   partitionedTableFunction
   ;

partitionedTableFunction
@init { gHiveParser.pushMsg("ptf clause", state); }
@after { gHiveParser.popMsg(state); } 
   :
   name=Identifier LPAREN KW_ON 
   ((partitionTableFunctionSource) => (ptfsrc=partitionTableFunctionSource spec=partitioningSpec?))
   ((Identifier LPAREN expression RPAREN ) => Identifier LPAREN expression RPAREN ( COMMA Identifier LPAREN expression RPAREN)*)?
   ((RPAREN) => (RPAREN)) ((Identifier) => alias=Identifier)?
   ->   ^(TOK_PTBLFUNCTION $name $alias? $ptfsrc $spec? expression*)
   ; 

//----------------------- Rules for parsing whereClause -----------------------------
// where a=b and ...
whereClause
@init { gHiveParser.pushMsg("where clause", state); }
@after { gHiveParser.popMsg(state); }
    :
    KW_WHERE searchCondition -> ^(TOK_WHERE searchCondition)
    ;

searchCondition
@init { gHiveParser.pushMsg("search condition", state); }
@after { gHiveParser.popMsg(state); }
    :
    expression
    ;

//-----------------------------------------------------------------------------------

//-------- Row Constructor ----------------------------------------------------------
//in support of SELECT * FROM (VALUES(1,2,3),(4,5,6),...) as FOO(a,b,c) and
// INSERT INTO <table> (col1,col2,...) VALUES(...),(...),...
// INSERT INTO <table> (col1,col2,...) SELECT * FROM (VALUES(1,2,3),(4,5,6),...) as Foo(a,b,c)
valueRowConstructor
    :
    LPAREN precedenceUnaryPrefixExpression (COMMA precedenceUnaryPrefixExpression)* RPAREN -> ^(TOK_VALUE_ROW precedenceUnaryPrefixExpression+)
    ;

valuesTableConstructor
    :
    valueRowConstructor (COMMA valueRowConstructor)* -> ^(TOK_VALUES_TABLE valueRowConstructor+)
    ;

/*
VALUES(1),(2) means 2 rows, 1 column each.
VALUES(1,2),(3,4) means 2 rows, 2 columns each.
VALUES(1,2,3) means 1 row, 3 columns
*/
valuesClause
    :
    KW_VALUES valuesTableConstructor -> valuesTableConstructor
    ;

/*
This represents a clause like this:
(VALUES(1,2),(2,3)) as VirtTable(col1,col2)
*/
virtualTableSource
   	:
   	LPAREN valuesClause RPAREN tableNameColList -> ^(TOK_VIRTUAL_TABLE tableNameColList valuesClause)
   	;
/*
e.g. as VirtTable(col1,col2)
Note that we only want literals as column names
*/
tableNameColList
    :
    KW_AS? identifier LPAREN identifier (COMMA identifier)* RPAREN -> ^(TOK_VIRTUAL_TABREF ^(TOK_TABNAME identifier) ^(TOK_COL_NAME identifier+))
    ;

//-----------------------------------------------------------------------------------