package cn.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.web.model.Product;
import cn.web.utils.JdbcUtils;

public class ProductDaoImpl {

	public static void main(String[] args) {
	 ProductDaoImpl daoImpl = new ProductDaoImpl();
	 String name = "Iphone Xr";
	 Double price = 6499.00;
	 String remark = "全面屏";
	 daoImpl.save(name, price, remark);
	 Product product = new Product();
	 product.setName("Mate 20 pro");
	 product.setPrice(4999.00);
	 product.setRemark("华为手机Mate20 pro");
	 daoImpl.save(product);
	 daoImpl.Delete(1);
	 }
	public int Delete(int id){
		
		Connection conn = null;
		PreparedStatement pre = null;
		
		try {
			conn = JdbcUtils.getConnection();
			pre = conn.prepareStatement("delete from product where id = ?");
			pre.setInt(1, id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		try {
			return pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	public int save(String name,Double price, String remark){
		Connection conn = null;
		PreparedStatement pre = null;
		
		try {
			conn = JdbcUtils.getConnection();
		    pre = conn.prepareStatement("insert into product (name,price,remark) values (?,?,?)");
		    pre.setString(1, name);
		    pre.setDouble(2, price);
		    pre.setString(3, remark);
		    }catch (SQLException e) {
				throw new RuntimeException();
			}
		try {
			return pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
}
	public int save(Product product) {
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = JdbcUtils.getConnection();
		    pre = conn.prepareStatement("insert into product (name,price,remark) values (?,?,?)");
		    pre.setString(1,product.getName());
		    pre.setDouble(2,product.getPrice());
		    pre.setString(3,product.getRemark());
		    }catch (SQLException e) {
				throw new RuntimeException();
			}
		try {
			return pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
