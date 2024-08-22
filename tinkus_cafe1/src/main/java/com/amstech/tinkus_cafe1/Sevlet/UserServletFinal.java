package com.amstech.tinkus_cafe1.Sevlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.amstech.tinkus_cafe1.DBUtil.DBUtil;
import com.amstech.tinkus_cafe1.Service.UserService;
import com.amstech.tinkus_cafe1.dao.UserDAO;
import com.amstech.tinkus_cafe1.dto.UserDTO;

/**
 * Servlet implementation class UserServletFinal
 */
@WebServlet("/UserServletFinal")
public class UserServletFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private DBUtil dbUtil;
     private UserDAO userDAO;
     private UserService userService;
 
	public UserServletFinal() {
	this.dbUtil=new DBUtil();
	this.userDAO =new UserDAO(dbUtil);
	this.userService=new UserService(userDAO);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		String task = request.getParameter("task");
		System.err.println("task: " + task);
		if (task == null) {
			System.err.println("Task cannot be null.");
			// throw excep
		} else if (task.equalsIgnoreCase("Login")) {
			FindByUserNamePassword(request,  response); // lOgin
			System.out.println("task done");
		} else if (task.equalsIgnoreCase("singup")) {
			Save(request, response);

		} else {
			System.err.println("No  found");
			// throw excep
		}
	}
	
	
	private void Save(HttpServletRequest request, HttpServletResponse response) {
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstname(request.getParameter("firstname"));
		userDTO.setLastname(request.getParameter("lastname"));
		userDTO.setAddress(request.getParameter("address"));
		userDTO.setMobilenumber(request.getParameter("mobilenumber"));
		userDTO.setGender(request.getParameter("gender"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO.setDob(request.getParameter("dob"));
		userDTO.setCityId(1);
		userDTO.setEmail(request.getParameter("email"));
		
		try {
			int count = userService.save(userDTO);
			if (count > 0) {
				System.out.println("user account created successfully.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Falied  created to user account  ");
		}
	}
	
	
	private void FindByUserNamePassword(HttpServletRequest request, HttpServletResponse response)  {
		String username=request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username"+username);
		System.out.println("password"+password);
		try {
			UserDTO userDTO = userService.FindByUserNamePassword(username, password);
			if(userDTO == null) {
				System.out.println("User login successfully.");
			System.out.println("username"+userDTO.getFirstname());
			System.out.println("password"+userDTO.getPassword());
			}else {
				System.out.println("falied to User login");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
}
