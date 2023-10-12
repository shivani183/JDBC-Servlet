package controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Politics;
import servicefactory.PoliticsServiceFactory;
import service.IPoliticsService;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IPoliticsService polService=PoliticsServiceFactory.getPoliticsService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addform")) {
			String pexpert = request.getParameter("pexpert");
			String pname = request.getParameter("pname");
			String pparty = request.getParameter("pparty");

			Politics politics = new Politics();
			politics.setPname(pname);
			politics.setPexpert(Integer.parseInt(pexpert));
			politics.setPparty(pparty);
			

			String status = polService.addPolitics(politics);
			PrintWriter out = response.getWriter();
			

			if (status.equals("success")) {
				out.println("<body>");
				out.println("<center>");
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
				out.println("</center>");
				out.println("</body>");
			} else {
				out.println("<body>");
				out.println("<center>");
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
				out.println("</center>");
				out.println("</body>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("searchform")) {
			String pid = request.getParameter("pid");

			Politics politics = polService.searchPolitics(Integer.parseInt(pid));
			PrintWriter out = response.getWriter();
			if (politics != null) {
				out.println("<body>");
				out.println("<br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>ID</th><td>" + politics.getPid() + "</td></tr>");
				out.println("<tr><th>NAME</th><td>" + politics.getPname() + "</td></tr>");
				out.println("<tr><th>AGE</th><td>" + politics.getPparty() + "</td></tr>");
				out.println("<tr><th>ADDRESS</th><td>" + politics.getPexpert() + "</td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
			} else {
				out.println("<body>");
				out.println("<center>");
				out.println("<h1 style='color:red;text-align:center;'>RECORD NOT AVAILABLE FOR THE GIVEN ID " + pid
						+ "</h1>");
				out.println("</center>");
				out.println("</body>");
			}
			out.close();
		}
		if(request.getRequestURI().endsWith("deleteform")){
			String pid = request.getParameter("pid");
			String status = polService.deletePolitics(Integer.parseInt(pid));
			PrintWriter out = response.getWriter();
			if(status=="success") {
				out.println("<body>");
				out.println("<center>");
				out.println("<h1 style='color:green;text-align:center;'>RECORD DELETED SUCCESSUFULLY " + pid
						+ "</h1>");
				out.println("</center>");
				out.println("</body>");
			}else if(status=="failure") {
				out.println("<body>");
				out.println("<center>");
				out.println("<h1 style='color:red;text-align:center;'>RECORD DELETION FAILED " + pid
						+ "</h1>");
				out.println("</center>");
				out.println("</body>");
			}else {
				out.println("<body>");
				out.println("<center>");
				out.println("<h1 style='color:orange;text-align:center;'>RECORD NOT AVAILABLE FOR THE GIVEN ID " + pid
						+ "</h1>");
				out.println("</center>");
				out.println("</body>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("editform")) {
			String pid = request.getParameter("pid");

			Politics politics = polService.searchPolitics(Integer.parseInt(pid));
			PrintWriter out = response.getWriter();
			if (politics != null) {
				// display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				out.println("<form method='post' action='./controller/updateRecord'>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>" + politics.getPid() + "</td></tr>");
				out.println("<input type='hidden' name='sid' value='" + politics.getPid() + "'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + politics.getPname()
						+ "'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='" + politics.getPparty()
						+ "'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='" + politics.getPexpert()
						+ "'/></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			} else {
				// display not found message
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + pid
						+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("updateRecord")) {
			String pid = request.getParameter("pid");
			String pname = request.getParameter("pname");
			String pparty = request.getParameter("pparty");
			String pexpert = request.getParameter("pexpert");

			Politics politics = new Politics();
			politics.setPid(Integer.parseInt(pid));
			politics.setPparty(pparty);
			politics.setPname(pname);
			politics.setPexpert(Integer.parseInt(pexpert));

			String status = polService.updatePolitics(politics);
			PrintWriter out = response.getWriter();

			if (status.equals("success")) {
				out.println("<body>");
				out.println("<h1 style='color:green; text-align:center;'>ONE RECORD UPDATED SUCCESSFULLY</h1>");
				out.println("</body>");
			} else {
				out.println("<body>");
				out.println("<h1 style='color:green; text-align:center;'>RECORD UPDATION FAILED</h1>");
				out.println("</body>");
			}
			out.close();

		}
	}

}
