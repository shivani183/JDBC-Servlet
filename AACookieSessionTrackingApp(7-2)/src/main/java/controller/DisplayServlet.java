package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/disp")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection connection = null;
		PreparedStatement ptmt=null;
		String sqlInsertQuery = "insert into product(name,cost,brand,category,quantity,manufacturer) values"
				+ "(?,?,?,?,?,?)";
		
			try {
				connection=Jdbc_Util.jdbcSetConnection();
				if(connection!=null) 
					ptmt=connection.prepareStatement(sqlInsertQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
		String pcategory = request.getParameter("pcategory");
		String pmanufacturer = request.getParameter("pmanufacturer");

		Cookie[] cookies = request.getCookies();
		String pname = cookies[0].getValue();
		String pcost = cookies[1].getValue();
		String pbrand = cookies[2].getValue();
		String pqty = cookies[3].getValue();

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body bgcolor='lightgreen'>");
		out.println("<h1 style='color:red; text-align:center;'>PRODUCT DETAILS...</h1>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		out.println("<tr><td>NAME</td><td>" + pname + "</td></tr>");
		out.println("<tr><td>COST</td><td>" + pcost + "</td></tr>");
		out.println("<tr><td>BRAND</td><td>" + pbrand + "</td></tr>");
		out.println("<tr><td>QTY</td><td>" + pqty + "</td></tr>");
		out.println("<tr><td>CATEGORY</td><td>" + pcategory + "</td></tr>");
		out.println("<tr><td>MANUFACTURER</td><td>" + pmanufacturer + "</td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		if(ptmt!=null) {
			try {
				ptmt.setString(1, pname);
				ptmt.setString(2, pcost);
				ptmt.setString(3, pbrand);
				ptmt.setString(4, pqty);
				ptmt.setString(5, pcategory);
				ptmt.setString(6, pmanufacturer);
				int row=ptmt.executeUpdate();
				if(row==1) {
					System.out.println("success");
				}
				else
					System.out.println("insertion failed");
				ptmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		

		


}
}