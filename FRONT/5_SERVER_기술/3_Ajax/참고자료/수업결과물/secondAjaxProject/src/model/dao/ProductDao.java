package model.dao;

import java.util.*;
import model.vo.Product;


public class ProductDao {
	private static ArrayList<Product> plist = 
			new ArrayList<Product>();
	
	public ProductDao(){}
	
	public String addProduct(Product p)
	{
		plist.add(p);
		
		return listString(plist);
	}
	
	public String deleteProduct()
	{
		plist.removeAll(plist);
		
		return "모두 삭제하였습니다.";
	}
	
	public String listString(ArrayList<Product> list){
		StringBuilder sb = new StringBuilder();
		
		for(Product p : list){
			sb.append(p.toString() + "\n");
		}
		
		return sb.toString();
	}
}
