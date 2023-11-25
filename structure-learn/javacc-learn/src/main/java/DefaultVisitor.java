/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */

/**
 * @author ningsheng
 * @version DefaultVisitor.java, v 0.1 2023年03月03日 1:51 PM ningsheng
 */
public class DefaultVisitor implements Example4Visitor {
    public void defaultVisit(SimpleNode node, Object data){
        node.childrenAccept(this, data);
    }
    @Override
    public Object visit(SimpleNode node, Object data) {
        defaultVisit(node, data);
        return data;
    }

    @Override
    public Object visit(ASTStart node, Object data) {
        defaultVisit(node, data);
        return data;
    }

    @Override
    public Object visit(ASTAdd node, Object data) {
        defaultVisit(node, data);
        return data;
    }

    @Override
    public Object visit(ASTMult node, Object data) {
        defaultVisit(node, data);
        return data;
    }

    @Override
    public Object visit(ASTMyOtherID node, Object data) {
        defaultVisit(node, data);
        return data;
    }

    @Override
    public Object visit(ASTInteger node, Object data) {
        defaultVisit(node, data);
        return data;
    }
}