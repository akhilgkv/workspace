package com.lara;


public class M1 {

	public static void main(String[] args) throws Exception 
	{
		Class c1 = Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println(c1);	
	}
}