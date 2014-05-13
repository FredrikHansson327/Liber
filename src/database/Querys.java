package database;

import java.sql.*;
import java.util.*;

public class Querys{

	
	public static ArrayList<String> getDocByTitle(String title){
	
		ArrayList<String> temp = new ArrayList<String>();
		
		temp = Querys.ask("Dok", "title", title);
		
		return temp;
		
	}
	
	
	
	public static ArrayList<String> getDocByAuthor(String author){
		
		ArrayList<String> temp = new ArrayList<String>();
		
		temp = Querys.ask("Dok", "author", author);
		
		return temp;
		
	}
	
	
	
	public static ArrayList<String> getDocByID(String id){
		
		ArrayList<String> temp = new ArrayList<String>();
		
		temp = Querys.ask("Dok", "dok_id", id);
		
		return temp;
		
	}
	
	
	
	
		
	
	
	
	
	public static ArrayList<String> ask(String table, String column, String key){
		Connection c 	= Connect.getConnection();
		Statement s 	= null;
		ResultSet rs 	= null;
		ArrayList<String> answer = new ArrayList<String>();

		try{
			s = c.createStatement();
		}
		catch (SQLException se){
			System.out.println("Error while creating statement");
			System.out.println(se.getMessage());
		}

		try{
			String question = "SELECT * FROM " + table + " WHERE " + column +" = '" + key + "';";
			rs = s.executeQuery(question);
		}//try
		catch (SQLException se) {
			System.out.println("Error while creating ResultSet");
			System.out.println(se.getMessage());
		}

		try{
			int len  = rs.getMetaData().getColumnCount();
			String temp="";
			while(rs.next()){
				for(int i=1; i<=len; i++){
					temp = temp + "" + rs.getString(i);
				}
				answer.add(temp);
			}//while
		}
		catch (SQLException se) {
			System.out.println("Error while extracting data from ResultSet");
			System.out.println(se.getMessage());
		}

		return answer;

	}

}
