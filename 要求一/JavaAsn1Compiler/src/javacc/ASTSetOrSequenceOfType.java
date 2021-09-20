package javacc;
/* Generated By:JJTree: Do not edit this line. ASTSetOrSequenceOfType.java */

import java.io.*;

public class ASTSetOrSequenceOfType extends SimpleNode {
	public static final int SEQUENCE_OF = 0;
	public static final int SET_OF = 1;
	protected int type;

	protected void
	setType(int seq)
	{
		if(seq == 0)
			type = SEQUENCE_OF;
		else
			type = SET_OF;
	}

	protected boolean
	isSequenceOf()
	{
		if(type == SEQUENCE_OF)
			return true;

		return false;
	}

	protected boolean
	isSetOf()
	{
		if(type == SEQUENCE_OF)
			return false;

		return true;
	}
	

	/**
	 * Creates the source file for the named class, extending either the SetOf
	 * or SequenceOf class.
	 */
	public void
	generateClass(String name)
	{
		/*////////////////////////////////////////////////////////////////////////
		 * Added by Fatih Batuk to fix the problem at generation of SET OF classes
		 */
		SimpleNode main = (SimpleNode)this;
		String nodeType =  main.first_token.image; // "SET" or "SEQUENCE"
		if (nodeType.equalsIgnoreCase("SET")) {
			type = SET_OF; 
		}
		//////////////////////////////////////////////////////////////////////////
		
		try
		{
			String filename = null;
			if(AsnParser.outputDirectory != null)
				filename = new String(AsnParser.outputDirectory + System.getProperty("file.separator") + name + ".java");
			else
				filename = new String(name + ".java");

			OutputStream os = new FileOutputStream(filename);
			String templateName;

			if(isSetOf() == true)
			{
				templateName = "setof.template";
			}
			else
			{
				templateName = "sequenceof.template";
			}

			BufferedReader reader = new BufferedReader(new FileReader(templateName));		//modified by Fatih Batuk
			String line;
			while(true)
			{
				line = reader.readLine();
				if(line == null)
					break;

				int idx = line.indexOf('@');
				while(idx != -1)
				{
					int ndx = line.indexOf('@', idx + 1);
					if(ndx == -1)
						break;

					String directive = line.substring(idx + 1, ndx);
					if(directive.equals("name"))	// replace with the class name
					{
						String left = line.substring(0, idx);
						String right = line.substring(ndx + 1);
						line = new String(left + name + right);
					}

					if(directive.equals("package"))	// insert a list of declarations
					{
						if(AsnParser.outputPackage != null)
							line = new String("package " + AsnParser.outputPackage + ";");
						else
							line = "";

						continue;
					}

					if(directive.equals("elementtype"))	// insert a list of declarations
					{
						String elementType = getElementType();
						String left = line.substring(0, idx);
						String right = line.substring(ndx + 1);
						line = new String(left + elementType + right);
						System.out.println(line);
					}

					idx = line.indexOf('@');
				}

				os.write(line.getBytes());
				os.write(0x0a);
				os.flush();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private String
	getElementType()
	{
		String eType;

		int numChildren = jjtGetNumChildren();
		for(int i = 0; i < numChildren; i++)
		{
			Node n = jjtGetChild(i);
			if(n instanceof ASTBuiltinType)
			{
				ASTBuiltinType et = (ASTBuiltinType)n;
				eType = et.getClassName();
				eType = eType.replace('-', '_');
				return eType;
			}

			if(n instanceof ASTDefinedType)
			{
				ASTDefinedType et = (ASTDefinedType)n;
				eType = et.getClassName();
				eType = eType.replace('-', '_');
				return eType;
			}
		}

		// should throw an exception or something
		return "UnknownType";
	}

  public ASTSetOrSequenceOfType(int id) {
    super(id);
  }

  public ASTSetOrSequenceOfType(AsnParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AsnParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
