package UserInfo;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class UserInfo extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 * See 'TestProject.java' in the project to examine encoding/decoding examples
	 */
	public NumericString userID = new NumericString("userID");
	public PrintableString userName = new PrintableString("userName");
	public PrintableString password = new PrintableString("password");
	public ASN1Integer age = new ASN1Integer("age");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	UserInfo()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	UserInfo(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(userID);
		super.addElement(userName);
		super.addElement(password);
		super.addElement(age);
	/* end of element setup */
	}

	public static void main(String []args) {
		// 创建输出流变量
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		BerOutputStream out = new BerOutputStream(outStream);

		// 对rec这个类进行赋值
		// 赋值结果为rec(author= b'1234', title = b'1234', height = 1011, width = 21)
		Rectangle rec = new Rectangle();
		byte[] name = new byte[4];
		name[0] = '1';
		name[1] = '2';
		name[2] = '3';
		name[3] = '4';
		rec.author.setValue(name);
		rec.title.setValue(name);
		rec.height.setValue(1011);
		rec.width.setValue(21);

		// 对输出变量进行编码
		try {
			rec.encode(out);
			System.out.println(out.toString());
		}catch (java.io.IOException e1){
			System.out.println(e1);
		}

		// 将编码后的结果写入test_rec文件，此时文件是二进制数据
		File f = new File("test_rec");
		try{
			OutputStream outFile = new FileOutputStream(f);
			try{outFile.write(outStream.toByteArray());}
			catch (java.io.IOException e2){
				System.out.println(e2);
			}
		}catch(java.io.FileNotFoundException e1){
			System.out.println(e1);
		}

}
