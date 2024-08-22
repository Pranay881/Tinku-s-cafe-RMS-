package com.amstech.tinkus_cafe1.Sevlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class UserServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserServlet1() {
     
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("method:get");
//		String Username =request.getParameter("Username");
//		String Password =request.getParameter("Password");
//		System.out.println("Username"+Username);
//		System.out.println("Password"+Password);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("method:post");
		String Firstname =request.getParameter("firstname");
		String Lastname =request.getParameter("lastname");
		String Email =request.getParameter("email");
		String Mobilenumber =request.getParameter("mobilenumber");
		String Password =request.getParameter("Password");
		System.out.println("firstname="+Firstname);
		System.out.println("lastname="+Lastname);
		System.out.println("Email="+Email);
		System.out.println("Mobilenumber="+Mobilenumber);
		System.out.println("Password="+Password);
	}
	
	

}
