package krishna.service;

import krishna.dto.Student;

public interface IStudentservice {
	public String addStudent(String name, String city, Integer age);
	
	public Student searchStudent(Integer id);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer id);
}
