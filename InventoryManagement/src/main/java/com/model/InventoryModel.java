package com.model;

import java.util.List;

import com.dto.Bill;
import com.dto.BillProduct;
import com.dto.Product;
import com.dto.User;
import com.repository.InventoryDataBase;

public class InventoryModel {
	InventoryDataBase idb=InventoryDataBase.getInstance();
	public User getCurrentUser(String email, String password) {
		return idb.getCurrentUser(email,password);
	}
	public int addProduct(Product product) {
		return  idb.addProduct(product) ;
	}
	public List<Product> getProducts(int userId) {
		return idb.getProducts(userId);
	}
	public Product getParticularProduct(int productId) {
		return idb.getParticularProduct(productId);
	}
	public int updateProduct(Product product) {
		return idb.updateProduct(product);
	}
	public int addBill(String[] productId, User user, String[] productName, String[] actualPrices, String[] gstPrices,
			String[] retailPrices, String[] gstPercents, String[] qtys, String[] prices, String name, String phNo) {
		int n=productName.length;
		int[]id=new int[n];
		float[]aPrice=new float[n];
		float[]gstPrice=new float[n];
		float[]mrp=new float[n];
		float[]gstPercent=new float[n];
		int[] qty=new int[n];
		float[]price=new float[n];
		for(int i=0;i<n;i++) {
			aPrice[i]=Float.parseFloat(actualPrices[i]);
			gstPrice[i]=Float.parseFloat(gstPrices[i]);
			mrp[i]=Float.parseFloat(retailPrices[i]);
			gstPercent[i]=Float.parseFloat(gstPercents[i]);
			qty[i]=Integer.parseInt(qtys[i]);
			price[i]=Float.parseFloat(prices[i]);
			id[i]=Integer.parseInt(productId[i]);
		}
		return idb.addBill(id,user,productName,aPrice,gstPrice,mrp,gstPercent,qty,price,name,Long.parseLong(phNo));
	}
	public int newRegisteration(User user) {
		return idb.newRegisteration(user);
	}
	public int updatePassword(String email, String password) {
		return idb.updatePassword(email,password);
	}
	public int removeProduct(int id, int userId) {
		return idb.removeProduct(id,userId);
	}
	public List<Bill> fetchBill(int userId, String startDate, String endDate) {
		return idb.fetchBill(userId,startDate,endDate);
	}
	public List<BillProduct> fetchPurchaseDetails(int billId) {
		return idb.fetchPurchaseDetails(billId);
	}
	
}
