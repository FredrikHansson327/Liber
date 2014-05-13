package database;

import java.sql.*;
import java.io.*;


public class Connect{

	public static Connection getConnection(){
		Connection c =null;
		File filePath = new File("/Users/niklas/Documents/workspace/Nellwyn/bin/database/liber.db");
		

		try{
			c = DriverManager.getConnection("jdbc:sqlite:" + filePath );	
		}//try
		catch(SQLException se){
			System.out.println("Database connection failed.");
			System.out.println(se);
		}//catch

		return c;

	}//getConnection
}//class


