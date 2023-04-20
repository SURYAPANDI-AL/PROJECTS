package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.dto.User;
import com.model.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hit in the login servlet");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		System.out.println(password.getClass());
		InventoryModel cm = new InventoryModel();
		User currentUser = cm.getCurrentUser(email, password);
		System.out.println(currentUser);
		PrintWriter out = response.getWriter();
		if (currentUser == null) {
			System.out.println("-1");
			out.println(-1);
		} else if(password.equals("null")){
			System.out.println("1");
			out.println(1);
		}
		else {
			System.out.println("user");
			HttpSession session = request.getSession();
			session.setAttribute("user", currentUser);
			out.println("http://localhost:8080/InventoryManagement/home.html");
			
		}
	}

}
