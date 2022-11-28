package com.miniproject.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.miniproject.connection.Project_Connection;
import com.product.Product_List;

public class User_Login {
	 
	public void login() {
		String strEmail="";
		 String strPassword="";
		try {
			Project_Connection PC = new Project_Connection();
			Connection con =PC.ProjectCon();
			Scanner Scan = new Scanner(System.in);
			System.out.println("Inter the user Email ");
			String Inputemail =Scan.next();
			System.out.println("Inter the user Password ");
			String Inputpassword =Scan.next();
			PreparedStatement preparedStatement =con.prepareStatement("select * from singin_data");
			ResultSet e=preparedStatement.executeQuery();
			//shivrajchouhan753@gmail.com
			//59048833
			   while(e.next())
			   {
			   strEmail =e.getString(1);
			   strPassword =e.getNString(2);
			   if(strEmail.equals(Inputemail ) && strPassword.equals(Inputpassword ))
				         {
				             Product_List PL = new Product_List();
				             PL.Pro_List();
				             Cart_Details cd = new Cart_Details();
				             cd.view_Cart();
				         }
			    }
			  con.close();
			  preparedStatement.close();
			  }
			  catch(Exception e)
			  {
			 System.out.println(e);
		}

	}

	

}