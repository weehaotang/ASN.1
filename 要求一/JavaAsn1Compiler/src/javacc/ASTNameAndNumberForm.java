package javacc;
/* Generated By:JJTree: Do not edit this line. ASTNameAndNumberForm.java */

public class ASTNameAndNumberForm extends SimpleNode {
  public ASTNameAndNumberForm(int id) {
    super(id);
  }

  public ASTNameAndNumberForm(AsnParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AsnParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
