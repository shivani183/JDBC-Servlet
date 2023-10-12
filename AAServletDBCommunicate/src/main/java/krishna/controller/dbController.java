package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connect=null;
	static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded succefully");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	}
	public void init() throws ServletException{
		System.out.println("Configure obj created");
		String url=getInitParameter("url");
		String username=getInitParameter("username");;
		String password=getInitParameter("password");;
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		try {
			DriverManager.getConnection(url,username,password);
			if(connect!=null) {
				System.out.println("Connection established successfully");
			}
		}catch(SQLException e) {
		}
	}
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("/db.html");
		out.println("<h1>Request type is :: " + request.getMethod() + "</h1>");

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select id,name,city,age from student");
			while (resultSet.next()) {
				// use resultSet and process it....

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
