package com.miniproject.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import com.miniproject.connection.Project_Connection;
import com.product.Product_List;

public class User_Sing_In {

	public void user() {
		
		//while(1>0)
		//{
		try {
		Project_Connection PC = new Project_Connection();
		Connection con =PC.ProjectCon();
		Scanner Scan = new Scanner(System.in);
		System.out.println("Sing In");
		System.out.println("Inter the user Email ");
		String email =Scan.next();
		System.out.println("Inter the user Password ");
		String password =Scan.next();
		PreparedStatement preparedStatement =con.prepareStatement("insert into SingIn_Data(Email ,Password ) values(?,?)");
		preparedStatement.setString(1,email);
		preparedStatement.setString(2,password);
		preparedStatement.executeUpdate();
	    System.out.println("Your are successfully Sing In");
	    System.out.println("*************************************************************");
	    Product_List PL = new Product_List();
	    PL.Pro_List();
	    System.out.println("************************************************************");
	    System.out.println("        1>Add product             2>Delete product");
	    Scanner sc=new Scanner(System.in);
	    int Choice= sc.nextInt();
	    switch(Choice) {
	    case 1:
	    Cart_Details CD = new Cart_Details();
	    CD.view_Cart();
	    break;
	    case 2:
	    	break;
	    default :
	    System.out.println("Invalid input ");
	    break;
	          
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