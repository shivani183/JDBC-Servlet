package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/test" }, 
	initParams = { @WebInitParam(name = "url", value = "jdbc:mysql:///school"),
		@WebInitParam(name = "user", value = "root"),
		@WebInitParam(name = "password", value = "Shivani123") }, 
	loadOnStartup = 10)

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	private PreparedStatement pstmt = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded succesfully...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		String jdbcUrl = getInitParameter("url");
		String user = getInitParameter("user");
		String password = getInitParameter("password");

		try {
			connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection established succesfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getContentType();
		String username = request.getParameter("username");
		String  usercity= request.getParameter("usercity");
		String userage = request.getParameter("userage");

		String sqlInsertQuery = "insert into student(name,city,age) values(?,?,?)";
		try {
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				pstmt.setString(1, username);
				pstmt.setString(2, usercity);
				pstmt.setInt(3, Integer.parseInt(userage));
				
			}
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				PrintWriter out = response.getWriter();
				if (rowAffected == 1) {
					out.println("<html>");
					out.println("<body>");
					out.println("<h1 style='color:green;text-align:center;'>REGISTRATION SUCCESFULL</h1>");
					out.println("</body>");
				} else {
					out.println("<html>");
					out.println("<body>");
					out.println(
							"<h1 style='color:red; text-align;center;'>REGISTRATION FAILED TRY AGAIN WITH THE FOLLOWING LINK</h1>");
					out.println("<a href='./reg.html'/>|REGISTRATION|</a>");
					out.println("</body>");
				}
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
