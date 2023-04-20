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

@WebServlet("/RemoveProductServlet")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("productId"));
		
		//log
		System.out.println("hit in rps"+id);
		InventoryModel inventoryModel= new InventoryModel();
		HttpSession session = request.getSession();
		User user= (User) session.getAttribute("user");
		int affectedRow=0;
		if(user!=null) {
			affectedRow=inventoryModel.removeProduct(id,user.getUserId());
		}
		PrintWriter out=response.getWriter();
		out.println(affectedRow+"");
	}

}
