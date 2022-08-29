package com.josh.java.training.quizproject.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnetion {

	 static Connection connection = null;
	 public static Connection openConnection() throws Exception {
	    	Class.forName("org.postgresql.Driver");
	        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/QuizProject","postgres","1234");
	        return connection;
	    }
	 
	 public static void closeConnection() throws Exception{
		 try
	        {
	            if(connection!=null)
	                connection.close();
	        }
	        catch(Exception ex)
	        {
	            ex.printStackTrace();
	        }
	 }
}
