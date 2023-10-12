package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Target.class is loading");
	}
	public TargetServlet() {
		System.out.println("Target obj is instantiation");
	}
	public void init() throws ServletException{
		System.out.println("Target obj is initialisation");
	}
	public void destroy() {
		System.out.println("Target obj is de-instantiation");

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("<h1>This is Target Servlet</h1>");
		out.print("</body>");
	
	}

}
