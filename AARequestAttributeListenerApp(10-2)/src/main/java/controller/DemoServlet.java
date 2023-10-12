package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static {
		System.out.println("DemoServlet.class is loading");
	}
    public DemoServlet() {
		System.out.println("DemoServlet obj is created");

    }

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	request.setAttribute("avi","python");
	request.setAttribute("ravi","C#");
	request.setAttribute("shivani","java");
	request.removeAttribute("ravi");
	request.setAttribute("ravi", "JavaScript");
	out.close();
	}
}
