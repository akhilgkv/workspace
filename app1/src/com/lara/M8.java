package com.lara;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class M8 {
	public static void main(String[] args) {
		Configuration c1 = new Configuration();
		c1.configure();

		SessionFactory sf = c1.buildSessionFactory();
		Session s1 = sf.openSession();

		try (FileReader fin = new FileReader("data.txt");
			 BufferedReader bin = new BufferedReader(fin))
		{
			Person p1 = null;
			s1.beginTransaction();
			String [] rowData;
			String row = bin.readLine();
			while(row != null)
			{
				rowData = row.split(",");
				p1= new Person();
				p1.setPersonId(Integer.parseInt(rowData[0].trim()));
				p1.setFirstName(rowData[1].trim());
				p1.setLastName(rowData[2].trim());
				s1.save(p1);
				row = bin.readLine();				
			}
			s1.getTransaction().commit();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}		
		System.out.println("done");
	}
}
