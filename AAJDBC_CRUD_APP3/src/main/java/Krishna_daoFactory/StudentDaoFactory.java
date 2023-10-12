package Krishna_daoFactory;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import Krishna_persistence.IStudentDao;
import Krishna_persistence.StudentDaoImpl;

@WebServlet("/DaoFactory")
public class StudentDaoFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDaoFactory() {}

	private static IStudentDao studentDao = null;

	public static IStudentDao getStudentDao() {
		if (studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}


}
