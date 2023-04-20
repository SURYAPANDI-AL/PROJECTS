package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dto.Product;
import com.model.InventoryModel;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId = Integer.parseInt(request.getParameter("pid"));
		InventoryModel model=new InventoryModel();
		
		Product product=model.getParticularProduct(productId);
		JSONObject obj=new JSONObject();
		obj.put("productId", product.getProductId());
		obj.put("productName", product.getProductName());
		obj.put("actualPrice", product.getActualPrice());
		obj.put("retailPrice", product.getRetailPrice());
		obj.put("gstPrice", product.getGstPrice());
		obj.put("gstPercent",product.getGstPercent());
		obj.put("stock",product.getStock());
		obj.put("userId",product.getUser_id());
	
		PrintWriter out = response.getWriter();
		out.println(obj);
	}

}
