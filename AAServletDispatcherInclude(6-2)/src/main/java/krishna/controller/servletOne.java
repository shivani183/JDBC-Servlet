package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletOne")
public class servletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("<h1>Inside Servlet-1</h1>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servletTwo");
		dispatcher.include(request, response);
		System.out.println("dispatching done");
		out.println("<h1>Hello again from servlet-1</h1>");
		out.println("</body>");
	
	
	}

}
