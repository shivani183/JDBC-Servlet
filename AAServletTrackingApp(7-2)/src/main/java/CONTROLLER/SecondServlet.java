package CONTROLLER;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String sdegi;
	public static String squal;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	squal = request.getParameter("squal");
	sdegi = request.getParameter("sdegi");
	
	HttpSession session = request.getSession(false);
	session.setAttribute("sdegi",sdegi);
	session.setAttribute("squal",squal);
	
	RequestDispatcher rd = request.getRequestDispatcher("./form3.html");
	rd.forward(request, response);
	
	
	
	}

}
