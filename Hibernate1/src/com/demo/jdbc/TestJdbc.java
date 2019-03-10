/**
 * 
 */
package com.demo.jdbc;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

/**
 * @author manu
 *
 */
public class TestJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
//		String user = "manu";
//		String pass = "Password";
//		try {
//			System.out.println("Connection Database :"+ url);
//			Connection myConnection= DriverManager.getConnection(url,user,pass);
//			System.out.println("Connection Sucessfull");
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

		//Create Session Factory
		
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		
		//Create Session
		 
		Session session = factory.getCurrentSession();
		org.hibernate.Transaction transaction =null;
		
		try {
			
			//use the session object to Save the Java Object
			
			 
			//Create Student Object 
			 System.out.println("Creating the new student Object......");
			 Student tempStudent = new Student("Paul","Wall","paul@gmail.com");
			
			//Start the Transaction
			 
			 session.beginTransaction();
			
			//Save the Student Object
			 
			 session.save(tempStudent);
			 System.out.println("Save the new student Object......");
			//Commit the Transaction
			 transaction=session.getTransaction();
			 transaction.commit();
			 System.out.println("Done!");
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}
		
		
		
	}

}
