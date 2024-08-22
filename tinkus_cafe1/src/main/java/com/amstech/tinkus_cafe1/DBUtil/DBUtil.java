package com.amstech.tinkus_cafe1.DBUtil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class DBUtil {
	
	private final String URL="jdbc:mysql://localhost/tinkus_cafe_rest";
	private final String USERNAME="root";
	private final String PASSWORD="root";
	private final String DRIVER="com.mysql.cj.jdbc.Driver";	
	
	public Connection getconnection() throws ClassNotFoundException, SQLException {
		System.out.println("connection mysql...");
     	Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("connection sussecfully..");
		return connection;
		
	}
	
	public void getclose(Connection connection,PreparedStatement pstmt) throws SQLException {
		System.out.println(" Closing Connection mysql..");
		if (pstmt != null) {
			pstmt.close();
		}
		if (connection !=null) {
			connection.close();
		}
		
	}
	public void getClose(Connection connection, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		System.out.println("Closing Connection mysql....");

		if (rs != null)
			rs.close();

		if (pstmt != null)
			pstmt.close();

		if (connection != null)
			connection.close();
	}
//	public static void main(String[]args) throws ClassNotFoundException, SQLException {
//		DBUtil user= new DBUtil();
//		user.getconnection();
//	}
	}	
	
	
	


   
	

	
	
   

