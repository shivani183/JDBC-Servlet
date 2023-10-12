package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InitializationParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<body>");
		out.println("<center><h1>Initialization Parameters</h1></center><hr>");
		out.println("<table border='1' align:center>");
		out.print("<tr><th>PrameterName</th><th>ParameterValue</th></tr>");
		
		Enumeration<String>paramNames=getInitParameterNames();
		while(paramNames.hasMoreElements()) {
			String paramName=(String)paramNames.nextElement();
			String value=getInitParameter(paramName);
			out.print("<tr><td>"+paramName+"</td><td>"+value+"</td></tr>");
			
		}
		out.println("</body>");
		out.println("</table>");
		out.println("</html>");
		out.close();
	}

}
