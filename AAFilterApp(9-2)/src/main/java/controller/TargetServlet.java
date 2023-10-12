package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	static{
		System.out.println("target servlet.class file is loading");
	}
    public TargetServlet() {
		System.out.println("target servlet.class file is instantiated");

    }

    public void init() {
		System.out.println("target servlet.class file is initialised");

    }
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>This is test servlet page</h1>");
	}
    public void destroy() {
    	System.out.println("target servlet de-Instantiated");
    }

	

}
