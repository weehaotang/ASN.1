package test;

/*
 * Created by Fatih Batuk to test the all project.
 */

import java.io.*;

import sequenceOfExample.*;

import choiceInsideSequence.MyChoice;

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.*;

import examples.*;
import example_cdr.*;
import air.*;

public class TestProject {
	public static void main(String[] args) {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();		
		BerOutputStream out = new BerOutputStream(outStream);
		//outStream.reset();
		UserInfo ui = new UserInfo();
		byte[] data = new byte[10];
		data[0] = '2';
		data[1] = '0';
		data[2] = '1';
		data[3] = '5';
		data[4] = '2';
		data[5] = '1';
		data[6] = '1';
		data[7] = '6';
		data[8] = '5';
		data[9] = '0';
		byte[] name = new byte[7];
		name[0] = 'a';
		name[1] = 'm';
		name[2] = 'a';
		name[3] = 'z';
		name[4] = 'i';
		name[5] = 'n';
		name[6] = 'g';
		ui.userID.setValue(data);
		ui.userName.setValue(name);
		ui.password.setValue(data);
		ui.age.setValue(21);
		try {
			ui.encode(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(out.toString());
		printHex(outStream.toByteArray());
		//write to file
		File f = new File("test_ui");
		  try{
		    OutputStream outFile = new FileOutputStream(f);
		    try{
		    	outFile.write(outStream.toByteArray());
		    	outFile.close();
		    }
		    catch (java.io.IOException e2){
		      System.out.println(e2);
		    }
		  }catch(java.io.FileNotFoundException e1){
		    System.out.println(e1);
		  }
		 //decode 
		  ByteArrayInputStream inputStream;
		  BerInputStream in;
		  inputStream = new ByteArrayInputStream(outStream.toByteArray());
		  in = new BerInputStream(inputStream);
		  UserInfo res = new UserInfo();
		  try {
			res.decode(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println("id = " + new String(res.userID.getValue()));
		  System.out.println("name = " + new String(res.userName.getValue()));
		  System.out.println("password = " + new String(res.password.getValue()));
		  System.out.println("age = " + res.age.getValue());

	}
	
	public static void printHex(byte[] coded) 
	{
		System.out.println("to byte array in HEX : ");
	    String hexDigits = "0123456789ABCDEF";
	    for (int i=0; i<coded.length; i++) {
	      int c = coded[i];
	      if (c < 0) c += 256;
	      int hex1 = c & 0xF;
	      int hex2 = c >> 4;
	      System.out.print(hexDigits.substring(hex2,hex2+1));
	      System.out.print(hexDigits.substring(hex1,hex1+1) + " ");
	    }
	    System.out.println();
	  }
	
	public static void printArray(byte[] array) {
		//System.out.println("to byte array in DEC : ");
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

}
