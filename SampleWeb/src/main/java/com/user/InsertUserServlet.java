package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String name = request.getParameter("name");
		String  email = request.getParameter("email");
		String  phone = request.getParameter("phone");
		String  username = request.getParameter("username");
		String  password = request.getParameter("password");
		
		
		
		PrintWriter out = response.getWriter();
		
		
		boolean isTrue;
		
		isTrue=UserDBUtill.insertUser(name, email, phone, username, password);
		
		if(isTrue == true) {
			
			/*RequestDispatcher dis = request.getRequestDispatcher("massage.jsp");
			dis.forward(request, response);*/
			
			 response.sendRedirect("UserDisplayServlet");
			
			
			
		} else {
			
			out.println("alert('Data Insert Not Complete');");
		}
		
	}

}
