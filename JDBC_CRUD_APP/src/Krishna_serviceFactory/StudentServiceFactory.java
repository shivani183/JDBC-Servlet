package Krishna_serviceFactory;

import krishna.service.IStudentservice;
import krishna.service.StudentServiceImpl;

//Connection connection=DriverManager.getConnection(url,user,pass)
public class StudentServiceFactory {
	
// making constructor private
	//Abstraction logic of implementation
	private StudentServiceFactory() {
		
	}
	private static IStudentservice studentService=null;
	
	//singleton pattern code
	
	public static IStudentservice getStudentService() {
		
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
		
	}
}
