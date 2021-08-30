package com.nathan.learn.parse;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.tree.BaseTree;

public class ETree1Test {
    public static void main(String[] args) throws Exception {
//        ANTLRInputStream input = new ANTLRInputStream(System.in);
//        ETree1Lexer lexer = new ETree1Lexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        ETree1Parser parser = new ETree1Parser(tokens);
//        ETree1Parser.expression_return r = parser.expression();
//        System.out.println(((BaseTree) r.getTree()).toStringTree());
//        printTree((BaseTree) r.getTree());
    }

    static String pStr = "";

    public static void printTree(BaseTree tree) {
        pStr += " ";
        System.out.println(pStr + tree.getText());
        for (int i = 0; i < tree.getChildCount(); i++) {
            BaseTree currTree = (BaseTree) tree.getChild(i);
            printTree(currTree);
        }
        pStr = pStr.substring(0, pStr.length() - 4);
    }
}
