package javacc;
/* Generated By:JJTree: Do not edit this line. ASTBinaryString.java */

public class ASTBinaryString extends SimpleNode {
  public ASTBinaryString(int id) {
    super(id);
  }

  public ASTBinaryString(AsnParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AsnParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
