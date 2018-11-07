package cn.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.web.utils.JdbcUtils;

public class BaseDao {
	//编写一个公共的父类，此类方法用来抽取共性的代码，子dao都需要基层此类
  protected int update(String sql,Object[] param) {
	  Connection conn = null;
	  PreparedStatement pre = null; 
	  try {
		conn = JdbcUtils.getConnection(); 
		pre = conn.prepareStatement(sql);
		for(int i = 0;i <param.length;i++) {
			pre.setObject(i+1, param[i]);
			System.out.println("循环一次");
		}
		return pre.executeUpdate();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}finally {
		JdbcUtils.close(conn, pre);
	}
	  
	
	
}
	
}
