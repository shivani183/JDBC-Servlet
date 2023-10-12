package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("html");
		out.println("<head><title>MSg</title></head>");
		out.println("body");
		out.println("<h1>RequestURI "+ request.getRequestURI()+"</h1>");
		out.println("<h1>ContextPath "+ request.getContextPath()+"</h1>");
		out.println("<h1>ServletPath "+ request.getServletPath()+"</h1>");
		out.println("<h1>PathInfo "+ request.getPathInfo()+"</h1>");
		out.println("<h1>QueryString "+ request.getQueryString()+"</h1>");
		out.println("<h1>ServerPort "+ request.getServerPort()+"</h1>");
		out.println("/body");
		out.println("/html");
		
	}


}
