package cn.web.service;

import java.util.List;

import cn.web.dao.ProductDaoImpl;
import cn.web.model.Product;
public class ProductServiceImpl {
	
	private ProductDaoImpl productDao = new ProductDaoImpl();
	public int Delete(int id){
		return productDao.Delete(id);
	}
	
	public int save(Product product) {
		return productDao.save(product);
	}
	public int update(Product product) {
		return productDao.update(product);
	}
	public Product getById(int id) {
		return productDao.getById(id);
	}

	public List<Product> queryByName(String keyword) {
		return productDao.queryByName(keyword);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		}
	
}
