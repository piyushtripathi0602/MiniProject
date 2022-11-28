package com.miniproject.connection;

import java.util.Scanner;



import com.miniproject.admin.Admin_Login;
import com.miniproject.admin.Insert_product;
import com.miniproject.user.User_Login;
import com.miniproject.user.User_Sing_In;

public class Choice {
	public void choice_Input() {
		System.out.println(" >Sing IN     2>User Login  3>Admin Login"); 
		System.out.println("**************************************************************************************************");
		System.out.println("Enter Your Choice");
		Scanner sc =new Scanner(System.in);
		int i = sc.nextInt();
		switch(i) {
		case 1:
			 User_Sing_In US = new  User_Sing_In();
				US.user();
				break;	
			
		case 2:
			   User_Login admin = new User_Login();
			   admin.login();
			break;
		case 3:
			Admin_Login Admin_Login = new Admin_Login();
			Admin_Login.login();
			break;
		default :
			         System.out.println("Invaid input");
		        
		}
	}

}

