package Krishna_persistence;

import javax.servlet.annotation.WebServlet;


import javax.servlet.http.HttpServlet;

import Krishna_dto.Student;

@WebServlet("/IStudentDao")
public interface IStudentDao  {
	
	public String addStudent(Student student);
	
	public Student searchStudent(Integer id);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer id);

}
