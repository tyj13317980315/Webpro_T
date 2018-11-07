package cn.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.web.utils.JdbcUtils;

public abstract class BaseDao<T> {
	//编写一个公共的父类，此类方法用来抽取共性的代码，子dao都需要基层此类
  protected abstract T getRow(ResultSet rs) throws SQLException;
  protected int update(String sql,Object... param) {
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
 /* protected T getById(String sql,int id) {
	  T model = null;
	  Connection conn = null;
	  PreparedStatement pre = null; 
	  ResultSet rs = null;
	  try {
		conn = JdbcUtils.getConnection(); 
		pre = conn.prepareStatement(sql);
        pre.setInt(1, id);
		rs=pre.executeQuery();
		if(rs.next()) {
			model = this.getRow(rs);
		}
		return model;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}finally {
		System.out.println("已经完成数据库查询，下一步要进行connection并打印");
		JdbcUtils.close(conn, pre);
	}
	  
  }*/
  protected List<T> queryByName(String sql, Object... param) {
		List<T> tList = new ArrayList<T>();
	    Connection conn = null;
		PreparedStatement pre = null; 
		ResultSet rs = null;
		
	    try {
	    	conn = JdbcUtils.getConnection(); 
	    	pre = conn.prepareStatement(sql);
	    	for(int i = 0;i<param.length;i++)
	    	   pre.setObject(i+1, param[i]);
	    rs = pre.executeQuery();	
	    while(rs.next()) {
	    	T t = this.getRow(rs);
	    	System.out.println("查到+1");;
	    	tList.add(t);
	    }
	    return tList;
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			JdbcUtils.close(conn, pre,rs);
		}
	   
  }       
	
}
