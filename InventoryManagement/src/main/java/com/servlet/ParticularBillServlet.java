package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.model.InventoryModel;
import java.util.List;


import com.dto.BillProduct;

@WebServlet("/ParticularBillServlet")
public class ParticularBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int billId = Integer.parseInt(request.getParameter("billId"));
		
		InventoryModel inventoryModel =  new InventoryModel();
		
		List <BillProduct> purchaseDetails = inventoryModel.fetchPurchaseDetails(billId);
		
		JSONArray arr = new JSONArray();
		
		//log
		System.out.println("Hit on the particular servlet ");
		
		for(int i=0;i<purchaseDetails.size();i++) {
			BillProduct product = purchaseDetails.get(i);
			JSONObject obj = new JSONObject();
			obj.put("productName", product.getProductName() );
			obj.put("price", product.getRetailPrice());
			obj.put("quantity", product.getQuantity());
			obj.put("totalprice", product.getTotalPrice());
			arr.add(obj);
		}
		
		//log
		System.out.println(arr);
		
		PrintWriter out = response.getWriter();
		out.println(arr);
		
	}

}
