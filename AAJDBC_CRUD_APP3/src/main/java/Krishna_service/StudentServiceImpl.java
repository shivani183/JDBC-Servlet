package Krishna_service;

import javax.servlet.annotation.WebServlet;


import javax.servlet.http.HttpServlet;

import Krishna_daoFactory.StudentDaoFactory;
import Krishna_dto.Student;
import Krishna_persistence.IStudentDao;
import Krishna_service.IStudentservice;

@WebServlet("/serviceImpl")
public class StudentServiceImpl implements IStudentservice {
	
	private IStudentDao stdDao =null;
	
	@Override
	public String addStudent(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
			return stdDao.addStudent(student);		
	}

	@Override
	public Student searchStudent(Integer id) {
		stdDao = StudentDaoFactory.getStudentDao();
		return 	stdDao.searchStudent(id);

	}

	@Override
	public String updateStudent(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);}

	@Override
	public String deleteStudent(Integer id) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(id);
	}


	

}
