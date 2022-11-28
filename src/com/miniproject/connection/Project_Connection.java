package com.miniproject.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Project_Connection {
     public Connection con=null;
	 public Connection ProjectCon()
	 {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root", "Rameshwari12@");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return con;
	 }

}
