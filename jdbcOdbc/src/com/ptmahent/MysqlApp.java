package com.ptmahent;

import java.sql.*;

/*
 * First Connecting to JDBC ODBC to mysql
 * using odbc connection
 * 
 */

public class MysqlApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch(ClassNotFoundException e) {
			System.out.println("Unable to load Driver Class");
			return;
		}
		
	
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = DriverManager.getConnection("jdbc:odbc:mysqldsn", "","");
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM employee");
				System.out.println("Connected");	
				while (rs.next()) {
					System.out.println(rs.getString("name") + " " + rs.getInt("salary"));
				}
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			
				if (conn != null) {
					conn.close();
				}
			}

			
		
		
		
	}

}
