package cn.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.web.model.Product;

public class ProductDaoImpl extends BaseDao<Product> {

	public static void main(String[] args) {
	 ProductDaoImpl daoImpl = new ProductDaoImpl();
	
	
	Product product = new Product();
	//product.setName("Iphone Xs max");
	//product.setPrice(9499.00);
	//product.setRemark("Xs Max比Xr贵啊");
	//product.setId(5);
	//daoImpl.update(product);
    product = daoImpl.getById(4);
	System.out.println(product.toString());
	//daoImpl.Delete(2);
	 }
	public Product getById(int id) {
		
		String sql = "select * from product where id = ?";
		return super.getById(sql, id);
	}
	public Product queryByName(String name) {
		Product product = new Product();
		return product;
	}
	
	public int Delete(int id){
		String sql = "delete from product where id = ?";
		return super.update(sql, new Object[] { id });
	}
	
	public int save(Product product) {
	    String sql ="insert into product (name,price,remark) values (?,?,?)";
	    return super.update(sql, new Object[] { product.getName(),product.getPrice(),product.getRemark()  });	    
	}
	public int update(Product product) {
		String sql="update product set name = ? ,price = ? ,remark = ? where id = ?";
		return super.update(sql, new Object[] { product.getName(),product.getPrice(),product.getRemark(),product.getId()  });
	}
	protected Product getRow(ResultSet rs) throws SQLException {
		//子类 将父类的abstract进行个性化实现;
		Product product = new Product();
		product.setName(rs.getString("name"));
        product.setId(rs.getInt("id"));
        product.setPrice(rs.getDouble("price"));
		product.setRemark(rs.getString("remark"));
		return product;
	}

}
