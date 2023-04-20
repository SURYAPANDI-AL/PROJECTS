package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dto.Bill;
import com.dto.Product;
import com.dto.User;
import com.model.InventoryModel;


@WebServlet("/FetchBillTableServlet")
public class FetchBillTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		InventoryModel inventoryModel = new InventoryModel();
		List <Bill> billList = inventoryModel.fetchBill(user.getUserId(),startDate,endDate);
		
		JSONArray arrayBill = new JSONArray();
		
		for(int i=0;i<billList.size();i++) {
			JSONObject bill = new JSONObject();
			Bill currentBill = billList.get(i);
			bill.put("billId", currentBill.getBillId());
			bill.put("customerName", currentBill.getCustomerName());
			bill.put("date", currentBill.getDate().toString());
			bill.put("time", currentBill.getTime().toString());
			bill.put("phoneNumber", currentBill.getPhoneNumber());
	
			arrayBill.add(bill);
		}
		PrintWriter out = response.getWriter();
		out.println(arrayBill);

	}

}
