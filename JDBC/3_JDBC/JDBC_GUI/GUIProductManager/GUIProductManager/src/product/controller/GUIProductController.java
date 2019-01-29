package product.controller;

import java.util.ArrayList;

import product.model.dao.ProductDao;
import product.model.vo.Product;

public class GUIProductController {
	public GUIProductController(){}

	public Product selectID(String pId) {
		ProductDao pDao = new ProductDao();
		Product p = pDao.selectID(pId);
		return p;
	}

	public ArrayList<Product> selectName(String text) {
		ProductDao pDao = new ProductDao();
		ArrayList<Product> list = pDao.selectName(text);
		return list;
	}

	public ArrayList<Product> selectAll() {
		ProductDao pDao = new ProductDao();
		ArrayList<Product> list = pDao.selectAll();
		return list;
	}

	public int insertRow(Product p) {
		ProductDao pDao = new ProductDao();
		int result = pDao.insertRow(p);
		return result;
	}

	public int updateRow(String pId, int price) {
		ProductDao pDao = new ProductDao();
		int result = pDao.updateRow(pId, price);
		return 0;
	}

	public int deleteRow(String pId) {
		ProductDao pDao = new ProductDao();
		int result = pDao.deleteRow(pId);
		return 0;
	}
	
	
}
