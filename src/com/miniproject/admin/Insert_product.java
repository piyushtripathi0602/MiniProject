package com.miniproject.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.miniproject.connection.*;
import com.product.Product_List;

public class Insert_product {

	public void product() {
		 System.out.println("Enter the number of product");
		 Scanner sc=new Scanner(System.in);
		int number = sc.nextInt();
		for(int i=1;i<=number;i++)
		{
		try {
			Project_Connection Project_Connection=new Project_Connection();
			Connection con=Project_Connection.ProjectCon();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the product Id > ");
		    int Product_Id=scan.nextInt();
			System.out.println("Enter the product name > ");
			String Name = scan.next();
			System.out.println("Enter the product price > ");
			int Price = scan.nextInt();
			System.out.println("Enter the product quantity > ");
			int Quantity = scan.nextInt();
			System.out.println("Enter the product description > ");
		    String Description=scan.next();
			
			PreparedStatement preparedStatement =con.prepareStatement("insert into product(Product_Id,Name,Price,Quantity,description) values(?,?,?,?,?)");
			preparedStatement.setInt(1,Product_Id);
			preparedStatement.setString(2,Name);
			preparedStatement.setInt(3,Price);
			preparedStatement.setInt(4,Quantity);
			preparedStatement.setString(5,Description);
			int j=preparedStatement.executeUpdate();
		    System.out.println("record is successfully inserted "+j);
			con.close();
			preparedStatement.close();
			
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
		
	  
	}
	}
	public void delete_product() {
		try {
			Product_List pl=new Product_List();
			pl.Pro_List();
		Project_Connection Project_Connection=new Project_Connection();
		Connection con=Project_Connection.ProjectCon();
		System.out.println("Enter the product which you want to remove");
		Scanner sc= new Scanner(System.in);
		String Product_name = sc.next();
		PreparedStatement preparedStatement =con.prepareStatement("delete from product where Name=?");
		preparedStatement.setString(1,Product_name);
		int i=preparedStatement.executeUpdate();
		System.out.println("Product");
		if(i>0)
		{
			System.out.println("Product deleted successfully");
		}
		else {
			System.out.println("Product is not available");
		}
		}
		
		catch(Exception e){
			System.out.println(e);
			
		}
	}

}
