package com.josh.java.training.quizproject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.josh.java.training.quizproject.dbutil.DBConnetion;

public class QuestionDAO {
	 private static PreparedStatement ps,ps1;
	 
	 static {
		 try {
			 ps=DBConnetion.openConnection().prepareStatement("Select QuestionID,QuestionDetails from question where SubjectID=?");
			 ps1=DBConnetion.openConnection().prepareStatement("Select  CorrectAnswer from question where QuestionID=?");
		 }
		 catch(Exception ex) {
			 
		 }
	 }
	 
	 public static Map<Integer,String> getQuestionsBySubjectID(int subjectID)throws SQLException
	    {
			System.out.println(subjectID);
		    ps.setInt(1, subjectID);
	        Map<Integer,String> questionMap=new HashMap<>();
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	questionMap.put(rs.getInt(1), rs.getString(2));
	        }
	        return questionMap;
	        
	    }
	 
	 public static int checkAnswerByQuestionID(int questionId)throws SQLException
	    {
		    ps1.setInt(1, questionId);
	        ResultSet rs=ps1.executeQuery();
	        if(rs.next())
	        {
	        	return rs.getInt(1);
	        }
	        else
	            return 0;
	    }
	 
}
