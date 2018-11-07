package cn.web.dao;

import cn.web.model.Product;

public class ProductDaoImpl extends BaseDao {

	public static void main(String[] args) {
	 ProductDaoImpl daoImpl = new ProductDaoImpl();
	
	
	Product product = new Product();
	product.setName("Iphone Xs max");
	product.setPrice(9499.00);
	product.setRemark("Xs Max比Xr贵啊");
	product.setId(5);
	daoImpl.update(product);
	daoImpl.Delete(2);
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
}
