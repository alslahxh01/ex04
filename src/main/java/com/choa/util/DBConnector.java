package com.choa.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnector {
	
	public static Connection getConnect(){
		Connection con = null;
		
		try {
			Context init = new InitialContext();
			DataSource dataSource = (DataSource)init.lookup("java:comp/env/jdbc/choa");
			con = dataSource.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void disconnect(PreparedStatement st , Connection con){
		try {
			st.close();
			DBConnector.disconnect(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void disconnect(PreparedStatement st , Connection con , ResultSet rs){
		try {
			rs.close();
			DBConnector.disconnect(st, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void disconnect(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
