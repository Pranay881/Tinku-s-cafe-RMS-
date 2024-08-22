package com.amstech.tinkus_cafe1.Service;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.amstech.tinkus_cafe1.dao.*;
import com.amstech.tinkus_cafe1.dto.*;

public class UserService {
	UserDAO UserDAO;
	
	public UserService(UserDAO UserDAO) {
		
		System.out.println("UserService Object Created");
		this.UserDAO = UserDAO;
		}
	
	public int  save(UserDTO userDTO) throws ClassNotFoundException, SQLException, ParseException {
		int count = UserDAO.save(userDTO);
		return count;
		
		
	}
	public int updateById(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		return UserDAO.updateById(userDTO);	
	}
	
	/*first that have made*/
//	public int DeleteById(UserDTO userDTO) throws Exception {
//		return UserDAO.DeleteById(userDTO);	
//	}
	
	public int DeleteById(int id) throws Exception {
		return UserDAO.DeleteById(id);
	}
	public List<UserDTO> findAll() throws Exception {
		return UserDAO.findAll();

	}

	public UserDTO findById(int id) throws Exception {
		return UserDAO.findById(id);
	}
	public UserDTO FindByUserNamePassword(String email ,String password) throws Exception {
		return  UserDAO.FindByUserNamePassword(email, password);
		
	}


	
	
	
}