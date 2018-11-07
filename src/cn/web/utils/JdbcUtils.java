package cn.web.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class JdbcUtils {
	static {
		System.out.println("Static..........");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
	public static Connection getConnection(){
		
		try {
			System.out.println("connection已打开");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		} catch (SQLException e) {	
			throw new RuntimeException(e);
		}
		
	}
	public static void close(Connection connection,Statement pre){
		try {
			if(pre != null && !pre.isClosed()) {
				pre.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(connection != null && !connection.isClosed()) {
				connection.close();	
				System.out.println("connection已关闭");
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public static void close(Connection connection,Statement pre,ResultSet rs){
		try {
			if(rs !=null && !rs.isClosed()) {
			rs.close();
			System.out.println("rs已关闭");}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}finally {
				
			
		try {
			if(pre != null && !pre.isClosed()) {
				pre.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(connection != null && !connection.isClosed()) {
				connection.close();	
				System.out.println("connection已关闭");
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
			}
	}
	public static void main(String[] args){
		
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn + "    已建立连接");
		}
}



