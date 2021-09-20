package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.ASN1Integer;


public class PortNumber extends ASN1Integer
{
	/**
	* If you have any constraint below, you must obey to the constraints.
	* If you do not consider the constraints when setting your element, you will get exception.
	*
	* To set your object, you can call setValue(..) method. Also it will be automatically set to "initialized" after setting the value.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	/* NO range constraint constants */
	
	/**
	* asn.1 INTEGER constructor to create "uninitialized" object.
	* setValue() method can be called to set the value of the integer.
	*/
	public
	PortNumber()
	{
		super();
	}

	/**
	* asn.1 INTEGER constructor to create "uninitialized" object.
	* setValue() method can be called to set the value of the integer.
	*/
	public
	PortNumber(String name)
	{
		super();
		setName(name);
	}
	
	/**
	* asn.1 INTEGER constructor to create "initialized" object.
	*/
	public
	PortNumber(long value)
	{
		super();
		setValue(value);
	}
	
	/**
	* constructor to build ASN1Integer with its value and name.
	*/
	public
	PortNumber(String name, long value)
	{
		super();
		setValue(value);
		setName(name);
	}
}
