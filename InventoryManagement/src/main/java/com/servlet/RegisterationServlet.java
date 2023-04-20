package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.User;
import com.model.InventoryModel;

@WebServlet("/RegisterationServlet")
public class RegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		long contact = Long.parseLong(request.getParameter("contact"));
		String shopName = request.getParameter("shopName");

		InventoryModel inventoryModel = new InventoryModel();

		User user = new User(name, shopName, email, contact, password);

		int result = inventoryModel.newRegisteration(user);

		//log
		System.out.println(result);
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
