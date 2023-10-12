package krishna.demoApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		cat(response);

	}

	
	  private void cat(HttpServletResponse response) throws IOException {
	  cat(response); PrintWriter out = response.getWriter();
	  System.out.println("hello"); }
	 
	@Override

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
