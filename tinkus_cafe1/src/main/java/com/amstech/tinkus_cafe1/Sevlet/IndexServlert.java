package com.amstech.tinkus_cafe1.Sevlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.amstech.tinkus_cafe1.DBUtil.DBUtil;
import com.amstech.tinkus_cafe1.Service.UserService;
import com.amstech.tinkus_cafe1.dao.UserDAO;
import com.amstech.tinkus_cafe1.dto.UserDTO;

@WebServlet
public class IndexServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DBUtil dbutil;
	private UserDAO userDAO;
	private UserService userSevice;
	
    public IndexServlert() {
    	System.out.println("object created");
    	
    	this.dbutil = new DBUtil();
		this.userDAO = new UserDAO(dbutil);
		this.userSevice = new UserService(userDAO);

    }

	



//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		      //reponse.getWriter().append('served at').append(request.getcontextpath());
			response.setContentType("text/html");//Set the content type
			System.out.println("send");
				
			PrintWriter Writer=response.getWriter();//get the Printwriter object



		Writer.append("<!DOCTYPE html>");
		Writer.append("<html>");
		Writer.append("<head>");
		Writer.append("<title>Home</title>");//write content use println()
		Writer.append("<style>");
		Writer.append("table, th, td {");
		Writer.append("border: 1px solid black;");
		Writer.append("}");
		Writer.append(".btn {");
		Writer.append("border: none;");
		Writer.append("color: white;");
		Writer.append(" padding: 14px 28px;");
		Writer.append("font-size: 16px;");
		Writer.append("cursor: pointer;");
		Writer.append("}");
		Writer.append(".success {background-color: #04AA6D;} /* Green */");
		Writer.append(".success:hover {background-color: #46a049;}");
		Writer.append(".danger {background-color: #f44336;} /* Red */ ");
		Writer.append(".danger {background-color: #f44336;} /* Red */ ");
		Writer.append("</style>");
		Writer.append("</head>");
		Writer.append("<body>");
		Writer.append("<h1>Welcome, intern to Amstech.</h1>");

		Writer.append("<table>");
		Writer.append("<tr>");
		Writer.append("<th>Id</th>");
		Writer.append("<th>First Name</th>");
		Writer.append("<th>Last Name</th>");
		Writer.append("<th>Address</th>");
		Writer.append("<th>Moblie number</th>");
		Writer.append("<th>Gendre</th>");
		Writer.append("<th>Email</th>");
		Writer.append("<th>Action</th>");
		Writer.append("</tr>");

		List<UserDTO> userDTOList= userSevice.findAll();
		for (UserDTO userDTO : userDTOList) {


		Writer.append("<tr>");
		Writer.append("<td>"+ userDTO.getId()  +"</td>");
		Writer.append("<td>"+ userDTO.getFirstname()  +"</td>");
		Writer.append("<td>"+ userDTO.getLastname()  +"</td>");
		Writer.append("<td>"+ userDTO.getAddress()  +"</td>");
		Writer.append("<td>"+ userDTO.getMobilenumber()  +"</td>");
		Writer.append("<td>"+ userDTO.getGender()  +"</td>");
		Writer.append("<td>"+ userDTO.getEmail() +"</td>");
		Writer.append("<td><button class=\"btn success\">Edit</button>" +
	              "<button class=\"btn danger\">Delete</button></td>");
		Writer.append("</tr>");
		}
		Writer.append("</table>");
		Writer.append("</body>");
		Writer.append("</html>");


			} catch (Exception e) {
					e.printStackTrace();
				}
			
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
