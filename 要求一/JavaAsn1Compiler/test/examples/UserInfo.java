package examples;

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
	public OctetString userID = new OctetString("userID");
	public OctetString userName = new OctetString("userName");
	public OctetString password = new OctetString("password");
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


}
