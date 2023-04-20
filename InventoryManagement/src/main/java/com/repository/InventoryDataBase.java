package com.repository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Base64;

import java.text.DateFormat;
import java.text.ParseException;

import com.dto.Bill;
import com.dto.BillProduct;
import com.dto.Product;
import com.dto.User;

public class InventoryDataBase {

	public static InventoryDataBase inventorydatabase;
	Connection con;
	Statement st;
	PreparedStatement pst;

	private InventoryDataBase() {

	}

	public static InventoryDataBase getInstance() {
		if (inventorydatabase == null) {
			inventorydatabase = new InventoryDataBase();
			inventorydatabase.getConnection();
		}
		return inventorydatabase;
	}

	private void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "Surya@2000");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User getCurrentUser(String email, String password) {
		
		String hashedPassword = hashPassword(password);
		System.out.println(hashedPassword);
		User curUser = null;
		try {
			String query = "select * from user where email_id='" + email + "' and password='" + hashedPassword + "'";
			if(password!=null) {
				query = "select * from user where email_id='" + email +"'";
			}
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String storeName = rs.getString(3);
				long phNo = rs.getLong(5);
				curUser = new User(id, name, storeName, email, phNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curUser;
	}

	public int addProduct(Product product) {
		try {
			String query = "insert into product (product_name,actual_price ,retail_price,gst_price ,gst_percent ,stock  ,user_id) values (?,?,?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, product.getProductName());
			pst.setDouble(2, product.getActualPrice());
			pst.setDouble(3, product.getRetailPrice());
			pst.setDouble(4, product.getGstPrice());
			pst.setDouble(5, product.getGstPercent());
			pst.setInt(6, product.getStock());
			pst.setInt(7, product.getUser_id());

			int i = pst.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Product> getProducts(int curUserId) {
		//log
		System.out.println(curUserId);
		Product product = null;
		List<Product> list = new ArrayList<>();
		try {
			String query = "select * from product where user_id='"+curUserId+"'";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String productName = rs.getString(2);
				float actualPrice = rs.getFloat(3);
				float retailPrice = rs.getFloat(4);
				float gstPrice = rs.getFloat(5);
				float gstPercent = rs.getFloat(6);
				int stock = rs.getInt(7);
				int userId = rs.getInt(8);
				product = new Product(id, productName, actualPrice, retailPrice, gstPrice, gstPercent, stock, userId);
				list.add(product);
				
				//log
				System.out.println(productName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Product getParticularProduct(int productId) {
		Product product = null;
		List<Product> list = new ArrayList<>();
		try {
			String query = "select * from product where id='" + productId + "'";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				String productName = rs.getString(2);
				float actualPrice = rs.getFloat(3);
				float retailPrice = rs.getFloat(4);
				float gstPrice = rs.getFloat(5);
				float gstPercent = rs.getFloat(6);
				int stock = rs.getInt(7);
				int userId = rs.getInt(8);
				product = new Product(productId,productName, actualPrice, retailPrice, gstPrice, gstPercent, stock, userId);
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public int updateProduct(Product product) {
		int update = 0;
		try {
			String query = "update product set product_name='" + product.getProductName() + "',actual_price='"
					+ product.getActualPrice() + "' ,retail_price='" + product.getRetailPrice() + "',gst_price='"
					+ product.getGstPrice() + "' ,gst_percent='" + product.getGstPercent() + "' ,stock='"
					+ product.getStock() + "' where id='" + product.getProductId() + "'";
			st = con.createStatement();
			update = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}

	public int addBill(int[] id, User user, String[] productName, float[] aPrice, float[] gstPrice, float[] mrp,
			float[] gstPercent, int[] qty, float[] price, String name, long phNo) {
		int rowAffected = 0;
		int billId = 0;
		try {
			String query = "insert into bill (customer_name,phNumber,UserId) values (?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setLong(2, phNo);
			pst.setInt(3, user.getUserId());
			rowAffected = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String query = "select id from bill order by id desc limit 1";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			billId = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rowAffected != 0) {
			try {
				for (int i = 0; i < aPrice.length; i++) {
					String query = "select * from product where id='" + id[i] + "'";
					st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					rs.next();
					int stock = rs.getInt("stock");
					int newStock=stock-qty[i];
					if(newStock<0)return 0;
					query="update product set stock='"+newStock+"' where id='"+id[i]+"'";
					st = con.createStatement();
					rowAffected+=st.executeUpdate(query);
					query = "insert into billProducts (product_name,actual_price,retail_price,gst_price,gst_percent,Qty,productTtlPrice,billId) values (?,?,?,?,?,?,?,?)";
					pst = con.prepareStatement(query);
					pst.setString(1, productName[i]);
					pst.setDouble(2, aPrice[i]);
					pst.setDouble(3, mrp[i]);
					pst.setDouble(4, gstPrice[i]);
					pst.setDouble(5, gstPercent[i]);
					pst.setInt(6, qty[i]);
					pst.setDouble(7, price[i]);
					pst.setInt(8, billId);
					rowAffected += pst.executeUpdate();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rowAffected;
	}

	public int newRegisteration(User user) {
		String hashedPassword = hashPassword(user.getPassword());
		try {
			String query = "select * from user where email_id='"+user.getEmail()+"' or phone='"+user.getPhNo()+"'";
			st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			if(rs.next()) {
				return 2;
			}else {
				query = "insert into user (name,storename,email_id,phone,password) values (?,?,?,?,?)";
				pst = con.prepareStatement(query);
				pst.setString(1, user.getName());
				pst.setString(2, user.getStoreName());
				pst.setString(3, user.getEmail());
				pst.setLong(4, user.getPhNo());
				pst.setString(5,hashedPassword);
				return pst.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updatePassword(String email, String password) {
		String hashedPassword = hashPassword(password);
		int update=0;
		try {
			String query = "update user set password='"+hashedPassword+"' where email_id='"+email+"'";
			st=con.createStatement();
			update=st.executeUpdate(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return update;
	}

	public int removeProduct(int id, int userId) {
		int affected=0;
		
		try {
			String query = "delete from product where user_id='"+userId+"' and id='"+id+"'";
			st=con.createStatement();
			affected=st.executeUpdate(query);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return affected;
	}

	public List<Bill> fetchBill(int userId, String startDate, String endDate) {
		System.out.println(startDate);
		System.out.println(endDate);
		
		List<Bill>  billsInformation = new ArrayList<>();
		try {
			String query = "Select * from bill where userId='"+userId+"' and  date(date) between '"+startDate+"' and '"+endDate+"' ";
			st=con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				int billId = rs.getInt(1);
				String name =rs.getString(2);
				Timestamp timeStamp =rs.getTimestamp(3);
				long phoneNumber = rs.getLong(4);
				Date date =new Date(timeStamp.getTime());
				Time time =new Time(timeStamp.getTime());
				Bill currentBill = new Bill(billId, name, date, time, phoneNumber);
				billsInformation.add(currentBill);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return billsInformation;
	}

	public List<BillProduct> fetchPurchaseDetails(int billId) {
		List<BillProduct> billProductsList = new ArrayList<>();
		try {
			String query = "select * from billproducts where billId='"+billId+"'";
			st=con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String productName=rs.getString(2);
				float actualPrice=rs.getFloat(3);
				float retailPrice=rs.getFloat(4);
				float gstPrice=rs.getFloat(5);
				float gstPercent=rs.getFloat(6);
				int Quantity=rs.getInt(7);
				float totalPrice=rs.getFloat(8);
				
				BillProduct billProduct =new BillProduct(productName, actualPrice, retailPrice, gstPrice, gstPercent, Quantity, totalPrice);
				billProductsList.add(billProduct);
				
			}
			
		}catch(Exception e)
		{
			  e.printStackTrace();
		}
		return billProductsList;
	}
	
	 public String hashPassword(String password) {
		 	if(password==null)
		 		return null;
	        String hashedPassword = "";
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
	            hashedPassword = Base64.getEncoder().encodeToString(hash);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return hashedPassword;
	    }
}
