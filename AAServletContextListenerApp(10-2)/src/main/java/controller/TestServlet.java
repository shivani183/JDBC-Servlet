package controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import krishna.ContextListener;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("TestServlet is loading");
	}
   
	public TestServlet() {
		System.out.println("TestServlet is instantiated");
    }
	public void init() throws ServletException{
		System.out.println("TestServlet is intialised");

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>This is RequestContextListener TestServlet</h1>");
		out.print(""
				+ "<h1> Count is "+ ContextListener.count+"</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
