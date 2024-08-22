package com.amstech.tinkus_cafe1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.amstech.tinkus_cafe1.DBUtil.DBUtil;
import com.amstech.tinkus_cafe1.dto.UserDTO;


public class UserDAO {
	private DBUtil dbUtil;

	public UserDAO(DBUtil dbUtil) {
		System.out.println("UserDAO Object Created.");
		this.dbUtil = dbUtil;
	}

	private final String USER_SAVE = "insert into user (first_name,last_name,address,moblie_number,gender,password,dob,City_id,email)"
			+ "value(?,?,?,?,?,?,?,?,?)";
	private final String UPDATE_BY_USER = "update user set first_name=?,last_name=?,moblie_number=?,gender=?,password=?,email=? where  id=?";
	private final String DELETE_BY_USER_ID = "delete from user where id in (?)";
	private final String USER_FIND_BY_ID = "select * from user where id=?";
	private final String USER_FIND_ALL = "select * from user";
    private final String FIND_BY_EMAIL_PASSWORD="select * FROM user WHERE (email = ? OR moblie_number = ?) AND password = ?";

	public int save(UserDTO userDTO) throws ClassNotFoundException, SQLException, ParseException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			// connection
			connection = dbUtil.getconnection();
			// pstmt
			pstmt = connection.prepareStatement(USER_SAVE);

			pstmt.setString(1, userDTO.getFirstname());
			System.out.println(userDTO.getFirstname());
			pstmt.setString(2, userDTO.getLastname());
			System.out.println(userDTO.getLastname());
			pstmt.setString(3, userDTO.getAddress());
			pstmt.setString(4, userDTO.getMobilenumber());
			System.out.println(userDTO.getMobilenumber());
			pstmt.setString(5, userDTO.getGender());
			pstmt.setString(6, userDTO.getPassword());
			System.out.println(userDTO.getPassword());
			// ---------------------------------
//			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//			java.util.Date date = sdf1.parse(userDTO.getDob());
//			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
			// ---------------------------------
			pstmt.setString(7, userDTO.getDob());
			pstmt.setInt(8, userDTO.getCityId());
//		pstmt.setString(7, userDTO.getDob());
			pstmt.setString(9, userDTO.getEmail());
			System.out.println(userDTO.getEmail());
			// EXC.
			// boolean status = pstmt.execute();
			return pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			// close
			dbUtil.getclose(connection, pstmt);
		}
	}

	public int updateById(UserDTO userDTO) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			// connection
			connection = dbUtil.getconnection();
			// pstmt
			pstmt = connection.prepareStatement(UPDATE_BY_USER);

			pstmt.setString(1, userDTO.getFirstname());
			pstmt.setString(2, userDTO.getLastname());
			pstmt.setString(3, userDTO.getMobilenumber());
			pstmt.setString(4, userDTO.getGender());
			pstmt.setString(5, userDTO.getPassword());
			pstmt.setString(6, userDTO.getEmail());
			pstmt.setInt(7, userDTO.getId());
			System.out.println("id=" + userDTO.getId());

			// execute
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			// close
			dbUtil.getclose(connection, pstmt);

		}
	}

	/* first that have made */
	/*
	 * public int DeleteById(double id) throws Exception { Connection connection
	 * =null; PreparedStatement pstmt=null; try { //connection
	 * connection=dbUtil.getconnection(); //pstmt pstmt
	 * =connection.prepareStatement(DELETE_BY_USER_ID);
	 * 
	 * pstmt.setInt(1,id.getId());
	 * 
	 * return pstmt.executeUpdate(); } catch (Exception e) { throw e; }finally {
	 * dbUtil.getclose(connection,pstmt); }
	 * 
	 * }
	 * 
	 * 
	 */
	public int DeleteById(double id) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = dbUtil.getconnection();
			pstmt = connection.prepareStatement(DELETE_BY_USER_ID);
			pstmt.setLong(1, (long) id);

			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			dbUtil.getclose(connection, pstmt);
		}
	}

	public UserDTO findById(int id) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO userDTO = null;
		try {
			connection = dbUtil.getconnection();
			pstmt = connection.prepareStatement(USER_FIND_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userDTO = new UserDTO();
				userDTO.setFirstname(rs.getString("first_name"));
				userDTO.setAddress(rs.getString("address"));
				userDTO.setPassword(rs.getString("password"));
				userDTO.setCityId(rs.getInt("city_id"));
				userDTO.setEmail(rs.getString("email"));
			}
			return userDTO;
		} catch (Exception e) {
			throw e;
		} finally {
			dbUtil.getClose(connection, pstmt, rs);
			;
		}
	}

	public List<UserDTO> findAll() throws Exception {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserDTO> userDTOList = new ArrayList<>();
		UserDTO userDTO = null;
		try {
//			connection = dbUtil.getConnection();
			connection = dbUtil.getconnection();
			pstmt = connection.prepareStatement(USER_FIND_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userDTO = new UserDTO();
				userDTO.setId(rs.getInt("Id"));
				userDTO.setFirstname(rs.getString("First_name"));
				userDTO.setLastname(rs.getString("last_name"));
				userDTO.setAddress(rs.getString("address"));
				userDTO.setMobilenumber(rs.getString("moblie_number"));
				userDTO.setGender(rs.getString("gender"));
				userDTO.setPassword(rs.getString("password"));
				userDTO.setCityId(rs.getInt("city_id"));
				userDTO.setEmail(rs.getString("email"));
				userDTOList.add(userDTO);
			}
			return userDTOList;
		} catch (Exception e) {
			throw e;
		} finally {
			dbUtil.getClose(connection, pstmt, rs);
		}

	}

	public UserDTO FindByUserNamePassword(String email, String password) throws Exception {
		
	   Connection connection=null;
	   PreparedStatement pstmt=null;
	   UserDTO userDTO=null;
	   try {
		   
		   connection =dbUtil.getconnection();
		   System.out.println("FindByUserNamePassword");
		   pstmt= connection.prepareStatement(FIND_BY_EMAIL_PASSWORD);
		   pstmt.setString(1, email);
		   pstmt.setString(2, email);
		   pstmt.setString(3, password);
		   ResultSet rs=pstmt.executeQuery();
		   if(rs.next()) {
			   userDTO = new UserDTO();
			 
				userDTO.setFirstname(rs.getString("first_name"));
				System.out.println(rs.getString("first_name"));
				
				userDTO.setMobilenumber(rs.getString("moblie_number"));
				userDTO.setPassword(rs.getString("password"));
				userDTO.setEmail(rs.getString("email"));
		   }
	       return userDTO;
	   }catch (Exception e) {
		   throw e;
	}
	   finally {
       dbUtil.getclose(connection, pstmt);
	   }
	}

//	public UserDTO findByUserNamePassword(String email, String password) throws Exception {
//		Connection connection = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		UserDTO userDTO = null;
//		try {
//			connection = dbUtil.getconnection();
//			pstmt = connection.prepareStatement(FIND_BY_EMAIL_PASSWORD);
//			pstmt.setString(1, email);
//			pstmt.setString(2, email);
//			pstmt.setString(3, password);
//			
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				userDTO = new UserDTO();
//				userDTO.setFirstname(rs.getString("first_name"));
//				userDTO.setPassword(rs.getString("password"));
//				userDTO.setEmail(rs.getString("email"));
//			}
//			return userDTO;
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			dbUtil.getClose(connection, pstmt, rs);
//		}
//	}
}
