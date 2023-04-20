package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.Product;
import com.dto.User;
import com.model.InventoryModel;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		System.out.println(request.getParameter("actualprice"));
		float actualprice=Float.parseFloat(request.getParameter("actualprice"));
		float retailprice=Float.parseFloat(request.getParameter("retailprice"));
		float gstprice=Float.parseFloat(request.getParameter("gstprice"));
		float gstpercent=Float.parseFloat(request.getParameter("gstpercent"));
		int stock=Integer.parseInt(request.getParameter("stock"));
		HttpSession session=request.getSession();
		User user= (User) session.getAttribute("user");
		System.out.println(stock);
		InventoryModel model=new InventoryModel();
		Product product=new Product(name, actualprice, retailprice, gstprice, gstpercent, stock,user.getUserId());
		int added =model.addProduct(product);
		PrintWriter out = response.getWriter();
		out.println(added+"");
			
	}

}
