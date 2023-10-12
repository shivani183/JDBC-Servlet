package Krishna_serviceFactory;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import Krishna_service.IStudentservice;
import Krishna_service.StudentServiceImpl;

@WebServlet("/ServiceFactory")
public class StudentServiceFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
private StudentServiceFactory() {
		
	}
	private static IStudentservice studentService=null;

	
	public static IStudentservice getStudentService() {
		
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
		
	}

}
