package Krishna_controller;

import java.io.IOException
;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Krishna_dto.Student;
import Krishna_service.IStudentservice;
import Krishna_serviceFactory.StudentServiceFactory;

@WebServlet("/test/addform")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	@SuppressWarnings("unused")
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IStudentservice stdService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addform")) {
			
			String age = request.getParameter("age");
			String name = request.getParameter("name");
			String city = request.getParameter("city");

			Student student = new Student();
			student.setName(name);
			student.setAge(Integer.parseInt(age));
			student.setCity(city);

			String status = stdService.addStudent(student);
			PrintWriter out = response.getWriter();

			if (status.equals("success")) {
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
			} else {
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
			}
			out.close();
		}
	
	}

}



