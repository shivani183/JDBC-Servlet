package krishna.service;

import Krishna_daoFactory.StudentDaoFactory;
import Krishna_serviceFactory.StudentServiceFactory;
import krishna.dto.Student;
import krishna.persistence.IStudentDao;

public class StudentServiceImpl implements IStudentservice {

	private IStudentDao stdDao =null;
	
	@Override
	public String addStudent(String name, String city, Integer age) {
		stdDao = StudentDaoFactory.getStudentDao();
			return stdDao.addStudent(name, city, age);		
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
