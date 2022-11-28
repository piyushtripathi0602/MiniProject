package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.miniproject.connection.Project_Connection;

public class Product_List {

	public void Pro_List() {
		try {
			
		Project_Connection PC=new Project_Connection();
		Connection con=PC.ProjectCon();
		PreparedStatement ps =con.prepareStatement("select * from product Name order by Name Asc");
		ResultSet e=ps.executeQuery();
		//ArrayList ArrayList = new ArrayList();
		System.out.println("**********Welcome To Group R Shell****** ");
		System.out.println(); 
				
				
		   while(e.next())
		   { 
		// System.out.println("         Product_Id >> "+e.getString(1)); 
		 System.out.println(" Name        : " +e.getString(2));
		 System.out.println(" Price       : " +e.getString(3));
		 System.out.println(" Quantity    : " +e.getString(4));
		 System.out.println(" Description : " +e.getString(5));
		 System.out.println(
				 
				 );
		   }
		   con.close();
		   ps.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
}
