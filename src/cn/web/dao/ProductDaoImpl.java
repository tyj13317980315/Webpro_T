package cn.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
 List<Product> proList = daoImpl.queryByName("one");
 		 for (Product temp : proList) {
 		 System.out.println(temp.toString());
 		 }
	
	//daoImpl.Delete(2);
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
    public Product getById(int id) {
		
		String sql = "select * from product where id = ?";
		List<Product> proList = super.queryByName(sql, id);
	    return proList.size()>0?proList.get(0):null;
    }
	public List<Product> queryByName(String keyword) {
		String sql = "select * from product where name like ?";
		return super.queryByName(sql, "%" + keyword + "%" );
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
