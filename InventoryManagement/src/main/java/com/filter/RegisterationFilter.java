package com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/RegisterationServlet")
public class RegisterationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String name=request.getParameter("userName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String contact=request.getParameter("contact");
		String shopName=request.getParameter("shopName");
		
		String namePattern = "^[a-zA-Z]+[ a-zA-Z]*$";
		String shopNamePattern = "^[a-zA-Z]+[ a-zA-Z]*$";
		String emailPattern = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		String passwordPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$";
		String contactPattern = "^[6-9]\\d{9}$";
		
		boolean isValidName = Pattern.compile(namePattern).matcher(name).matches();
		boolean isValidEmail = Pattern.compile(emailPattern).matcher(email).matches();
		boolean isValidPassword = Pattern.compile(passwordPattern).matcher(password).matches();
		boolean isValidContact = Pattern.compile(contactPattern).matcher(contact).matches();
		boolean isValidShopName = Pattern.compile(shopNamePattern).matcher(shopName).matches();
		
		System.out.println("hit on the filter");
		
		if(isValidName && isValidEmail && isValidPassword && isValidContact && isValidShopName) {
			chain.doFilter(request,response);
		}else {
			System.out.println("invalid data");
			PrintWriter out = response.getWriter();
			out.println(0);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
