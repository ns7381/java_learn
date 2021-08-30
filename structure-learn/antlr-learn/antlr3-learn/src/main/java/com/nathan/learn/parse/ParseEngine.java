package com.nathan.learn.parse;

import autogen.ELexer;
import autogen.EParser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.BaseTree;

public class ParseEngine {
    public static void main(String[] args) throws Exception {
        ANTLRStringStream input = new ANTLRStringStream("23+4*(5+1);");
        ELexer lexer = new ELexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EParser parser = new EParser(tokens);
        EParser.expression_return r = parser.expression();
        System.out.println(((BaseTree) r.getTree()).toStringTree());
    }
}
