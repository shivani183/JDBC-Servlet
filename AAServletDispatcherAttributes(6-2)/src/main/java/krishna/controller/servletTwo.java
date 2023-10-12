package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/two")
public class servletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	PrintWriter out = response.getWriter();
	out.println("<body>");
	out.println("<h1>welcome to Attributes</h1>");
	Enumeration<String> names = request.getAttributeNames();
	while(names.hasMoreElements()==true) {
		String name = (String)names.nextElement();
		out.println(name);
	}
	out.println("</body>");
	
	}

}
