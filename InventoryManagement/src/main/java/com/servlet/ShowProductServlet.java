package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.model.InventoryModel;
import java.util.ArrayList;
import java.util.*;
import com.dto.Product;
import com.dto.User;

/**
 * Servlet implementation class ShowProductServlet
 */
@WebServlet("/ShowProductServlet")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userId = user.getUserId();
		InventoryModel model = new InventoryModel();
		List<Product> list = model.getProducts(userId);

		JSONArray arr = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			Product curProduct = list.get(i);
			JSONObject obj = new JSONObject();
			obj.put("productId", curProduct.getProductId());
			obj.put("productName", curProduct.getProductName());
			obj.put("actualPrice", curProduct.getActualPrice());
			obj.put("retailPrice", curProduct.getRetailPrice());
			obj.put("gstPrice", curProduct.getGstPrice());
			obj.put("gstPercent", curProduct.getGstPercent());
			obj.put("stock", curProduct.getStock());
			obj.put("userId", curProduct.getUser_id());

			arr.add(obj);
		}
		System.out.println(arr);
		PrintWriter out = response.getWriter();
		out.println(arr);
	}

}
