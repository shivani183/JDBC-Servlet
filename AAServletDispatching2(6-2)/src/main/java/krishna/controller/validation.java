package krishna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validation")
public class validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("control in servlet1");
		String user = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		System.out.println(user +" "+password);
		
		if(user.equals("shivani") && password.equals("shivani123")) {
			RequestDispatcher reqDisp = request.getRequestDispatcher("/home");
			reqDisp.forward(request, response);
		}else {
			RequestDispatcher reqDisp = request.getRequestDispatcher("/error");
			reqDisp.forward(request, response);
		}

	}

}
