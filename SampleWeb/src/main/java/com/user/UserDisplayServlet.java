package com.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserDisplayServlet")
public class UserDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		List<user> userList = UserDBUtill.getAllUsers();
        
        request.setAttribute("userList", userList);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Display.jsp");
        
        dispatcher.forward(request, response);

	}

}
