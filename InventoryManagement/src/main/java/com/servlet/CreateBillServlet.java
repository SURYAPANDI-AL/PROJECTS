package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.User;
import com.model.InventoryModel;


@WebServlet("/CreateBillServlet")
public class CreateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("customerName");
		String phNo=request.getParameter("customerPhoneNumber");
		String[] productName=request.getParameter("productNames").split(",");
		String[] productId =request.getParameter("productIdString").split(",");
		String[] actualPrices=request.getParameter("actualPricesString").split(",");
		String[] gstPrices=request.getParameter("gstPriceString").split(",");
		String[] retailPrices=request.getParameter("retailPriceString").split(",");
		String[] gstPercents=request.getParameter("gstPercentString").split(",");
		String[] qtys=request.getParameter("qtyString").split(",");
		String[] prices=request.getParameter("priceString").split(",");
		
		InventoryModel model=new InventoryModel();
		HttpSession session =request.getSession();
		User user =(User) session.getAttribute("user");
		int success = model.addBill(productId,user,productName,actualPrices,gstPrices,retailPrices,gstPercents,qtys,prices,name,phNo);
		System.out.println(success);
		PrintWriter out = response.getWriter();
		if(success==((prices.length*2)+1)) {
			out.println(1);
		}else {
			out.println(0);
		}
	}

}
