package javacc;
/* Generated By:JJTree: Do not edit this line. ASTMacroReference.java */

public class ASTMacroReference extends SimpleNode {
  public ASTMacroReference(int id) {
    super(id);
  }

  public ASTMacroReference(AsnParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AsnParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
