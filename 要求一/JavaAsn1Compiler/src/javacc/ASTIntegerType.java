package javacc;
/* Generated By:JJTree: Do not edit this line. ASTIntegerType.java */

public class ASTIntegerType extends SimpleNode {
  public ASTIntegerType(int id) {
    super(id);
  }

  public ASTIntegerType(AsnParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AsnParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
