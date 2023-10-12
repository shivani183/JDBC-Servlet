package krishna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/one")
public class servletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("in servlet 1");
		
		request.setAttribute("shivani", "RBTS");
		request.setAttribute("avinash", "Mirzapur");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/two");
		dispatcher.forward(request, response);
		System.out.println("dispathing done");
	
	}

}
