package com.josh.java.training.quizproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.josh.java.training.quizproject.dao.QuestionDAO;
import com.josh.java.training.quizproject.dbutil.DBConnetion;

public class SubjectOptionController {

	public static void main(String[] args) {
		{
			int correctAnswerCount=0,totalQuestion=0;;
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter Your subject number for exam!");
			System.out.println("1.Java\n2.OOPS\n3.JDBC");
			try 
			{
				        int choice=scanner.nextInt();
				        Map<Integer,String>questions=QuestionDAO.getQuestionsBySubjectID(choice);
						for(Map.Entry<Integer,String> entry : questions.entrySet()){
							totalQuestion++;
							 System.out.println("-----------------------------------------------------------");
							String question=entry.getValue();
							System.out.println(question);
							System.out.println("\nEnter Your answer:");
							int userAnswer=scanner.nextInt();
							int actualAnswer=QuestionDAO.checkAnswerByQuestionID(entry.getKey());
							if(userAnswer==actualAnswer)
							{
								correctAnswerCount++;
							}
						}
						System.out.println("Total Answers were:"+totalQuestion);
						System.out.println("Correct Answers:"+(correctAnswerCount));
						System.out.println("Wrong Answers:"+(totalQuestion-correctAnswerCount));
						
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			finally {
				try {
					DBConnetion.closeConnection();
					scanner.close();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
