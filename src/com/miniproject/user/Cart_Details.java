package com.miniproject.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.miniproject.connection.Project_Connection;

public class Cart_Details {

	public void view_Cart() {
		try {
		Project_Connection Project_Connection=new Project_Connection();
		Connection con=Project_Connection.ProjectCon();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the product name to add in the cart > ");
	    String Product_Name=scan.next();
	    System.out.println("Enter the product Quantity");
	    int quantity= scan.nextInt();
	    PreparedStatement ps =con.prepareStatement("select * from product where name=?");
	    ps.setString(1,Product_Name);
		ResultSet e=ps.executeQuery();
		while(e.next())
		{
			//System.out.println(e.getInt(3));
			int amount =e.getInt(3)*quantity;
		    System.out.println("Total amount for cart is >> "+amount);
		}
		Cart_Details CD = new Cart_Details();
		CD.addItem();	//shyam
	    con.close();
	    ps.close();
	    e.close();
		}catch(Exception e)
		{
			System.out.println(e);  
		}
		
	}
	public void addItem() {
		System.out.println("Want to add the more Item");
		Scanner sc = new Scanner(System.in);
		String input =sc.next();
		if(input.equals("Yes"))
		{
			Cart_Details CD = new Cart_Details();
			CD.view_Cart();	
	  }
	}
}