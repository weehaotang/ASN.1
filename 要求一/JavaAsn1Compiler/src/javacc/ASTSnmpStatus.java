package javacc;
/* Generated By:JJTree: Do not edit this line. ASTSnmpStatus.java */

public class ASTSnmpStatus extends SimpleNode {
  public ASTSnmpStatus(int id) {
    super(id);
  }

  public ASTSnmpStatus(AsnParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AsnParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
