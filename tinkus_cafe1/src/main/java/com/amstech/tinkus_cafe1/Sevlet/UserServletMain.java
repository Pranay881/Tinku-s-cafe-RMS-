package com.amstech.tinkus_cafe1.Sevlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.amstech.tinkus_cafe1.DBUtil.DBUtil;
import com.amstech.tinkus_cafe1.Service.UserService;
import com.amstech.tinkus_cafe1.dao.UserDAO;
import com.amstech.tinkus_cafe1.dto.UserDTO;

public class UserServletMain {

	private DBUtil dbutil;
	private UserDAO userDAO;
	private UserService userSevice;
	
	
	
	public UserServletMain() {
		this.dbutil = new DBUtil();
		this.userDAO = new UserDAO(dbutil);
		this.userSevice = new UserService(userDAO);

	}

	public static void main(String[] args) throws Exception {
		UserServletMain main = new UserServletMain();
//		 main.Save();
//		main.updateById();
//		main.DeleteById();
		// main.findById();
		// main.findAll();
		 main.FindByUserNamePassword();

	}

	public void save() {

		UserDTO userDTO = new UserDTO();
		userDTO.setFirstname("payal");
		userDTO.setLastname("neelkhanth");
		userDTO.setAddress("pune");
		userDTO.setMobilenumber("8818827721");
		userDTO.setGender("F");
		userDTO.setPassword("p@123");
		userDTO.setDob("2003-12-01");
		userDTO.setCityId(3);
		userDTO.setEmail("payalneelkhanth881@gmail.com");

		try {
			int count = userSevice.save(userDTO);
			if (count > 0) {
				System.out.println("User account created successfully.");
				// servlet resp
			} else {
				System.out.println("Failed to create use account.");
				// servlet resp
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// process
			// servlet resp
		} catch (SQLException e) {
			e.printStackTrace();
			// process
			// servlet resp
		} catch (ParseException e) {
			e.printStackTrace();
			// process
			// servlet resp
		}
	}

	public void updateById() {

		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(4);
			userDTO.setFirstname("unnati");
			userDTO.setLastname("khushwah");
			userDTO.setMobilenumber("6267158998");
			userDTO.setPassword("@u123");
			userDTO.setCityId(1);
			userDTO.setGender("F");
			userDTO.setEmail("u@gamil.com");

			int count = userSevice.updateById(userDTO);
			if (count > 0) {
				System.out.println("User account updated successfully.");
				// resp
			} else {
				System.out.println("Failed to update user account.");
				// resp
			}
		} catch (Exception e) {
			e.printStackTrace();
			// resp
		}

	}

/*	public void DeleteById() throws Exception {
		
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(1);
			int count = userSevice.DeleteById(userDTO);
			if (count > 0) {
				System.out.println("User account deleted successfully.");
				// resp
			} else {
				System.out.println("Failed to delete user account.");
				// resp
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}*/
	
	public void DeleteById() {

		int id = 17;
		try {
			int count = userSevice.DeleteById(id);
			if (count > 0) {
				System.out.println("User account deleted successfully.");
				// resp
			} else {
				System.out.println("Failed to delete user account.");
				// resp
			}
		} catch (Exception e) {
			e.printStackTrace();
			// resp
		}
	}
	
	public void findById() {

		int userId = 3;
		try {
			UserDTO userDTO = userSevice.findById(userId);
			if (userDTO != null) {
				System.out.println("User found successfully.");
				System.out.println("FirstName: " + userDTO.getFirstname());
				System.out.println("address:" + userDTO.getAddress());
				System.out.println("Password:" + userDTO.getPassword());
				System.out.println("city_id:" + userDTO.getCityId());
				System.out.println("emali:" + userDTO.getEmail());

			} else {
				System.out.println("Failed to find user.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void findAll() {
//		UserDTO userDTO;
		try {
			List<UserDTO> userDTOlist = userSevice.findAll();

			if (!userDTOlist.isEmpty()) {
				System.out.println("User found Successfully");
				userDTOlist.forEach(ud -> {
					System.out.println("id:"+ ud.getId());
					System.out.println("Firstname:" + ud.getFirstname());
					System.out.println("lastname:" + ud.getLastname());
					System.out.println("address:" + ud.getAddress());
					System.out.println("mobile:" + ud.getMobilenumber());
					System.out.println("gender:" + ud.getGender());
					System.out.println("city_id:" + ud.getCityId());
					System.out.println("emali:" + ud.getEmail());
					System.out.println("======================================");
				});
			} else {
				System.out.println("no user found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

   public void FindByUserNamePassword() {
    	
		
		try {
			String email = " pw1@gmail.com";
			String password = "Abc@123456";
			
			UserDTO userDTO = userSevice.FindByUserNamePassword(email, password);
			if (userDTO != null) {
				System.out.println("User Found Succesfully");
				System.out.println("FirstName : "+ userDTO.getFirstname());
				System.out.println("Password : "+ userDTO.getPassword());
				
			}
			if (userDTO != null) {
				System.err.println("User login successfully.");
				System.err.println("FirstName: " + userDTO.getFirstname());
				System.err.println("LastName: " + userDTO.getLastname());
			
		} else {
				System.out.println("Failed to find User ");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

    }
	
	
}

