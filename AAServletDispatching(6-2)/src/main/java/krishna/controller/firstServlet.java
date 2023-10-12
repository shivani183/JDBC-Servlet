package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class firstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("in First servlet");
		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("<h1>Welcome to servlet program</h1>");
		out.println("</body>");
		RequestDispatcher reqDisp = request.getRequestDispatcher("/second");
	
		reqDisp.forward(request, response);
	}

}
