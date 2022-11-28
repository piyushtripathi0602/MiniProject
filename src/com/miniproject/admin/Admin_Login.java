package com.miniproject.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.miniproject.connection.Project_Connection;
import com.miniproject.user.User_Login;
import com.miniproject.user.User_Sing_In;
import com.product.Product_List;

public class Admin_Login {

	public void login() {
		String strEmail="";
		String strPassword="";
	try {
	Project_Connection PC = new Project_Connection();
	Connection con =PC.ProjectCon();
	
	Scanner Scan = new Scanner(System.in);
	System.out.println("Enter the user Email ");
	String Inputemail =Scan.next();
	System.out.println("Enter the user Password ");
	String Inputpassword =Scan.next();
	
	
	PreparedStatement preparedStatement =con.prepareStatement("select * from Admin_Login");
	ResultSet e=preparedStatement.executeQuery();
	while(e.next())
		{
		  strEmail =e.getString(1);
		  strPassword =e.getNString(2);
	if(strEmail.equals(Inputemail ) && strPassword.equals(Inputpassword ))
	     {
	 {  
	System.out.println("1>Check User  2>Insert Product  3>Remove Product"); 
	System.out.println("******************************");
	System.out.println("Enter Your Choice");
	Scanner sc =new Scanner(System.in);
	int i = sc.nextInt();
	 switch(i) {
				
	 case 1:
	 try {
	PreparedStatement ps =con.prepareStatement("select * from singin_data Email order by Email Asc");
	ResultSet f = ps.executeQuery();
	//ArrayList ArrayList = new ArrayList();
	System.out.println("**********Registered Users********* ");
	System.out.println();
		   while(f.next())
		   {  
	// System.out.println(" Product_Id >> "+e.getString(1)); 
	 System.out.println("User Name =" + f.getString(1));
	 System.out.println();
	}
			  ps.close();
			  f.close();
	 }	
		  catch(Exception E)
		 {	System.out.println(E);    }
	    break;	
			
	    
	    case 2:
		Insert_product IP = new Insert_product();
		   IP.product();
		  break;
		  
		  
		case 3:
		Insert_product IP1 = new Insert_product();
		IP1.delete_product();
			break;
		default :
		 System.out.println("  ");
		  }
	   }
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

