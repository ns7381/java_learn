
public class ASTMyOtherID extends SimpleNode {
    String name;
    public ASTMyOtherID(int id) {
        super(id);
    }

    public ASTMyOtherID(Example4 p, int id) {
        super(p, id);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Identifier: " + name;
    }



    /** Accept the visitor. **/
    public Object jjtAccept(Example4Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
