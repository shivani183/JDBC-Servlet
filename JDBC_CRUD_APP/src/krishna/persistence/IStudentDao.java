package krishna.persistence;

import krishna.dto.Student;

public interface IStudentDao {

	public String addStudent(String name, String city, Integer age);
	
	public Student searchStudent(Integer id);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer id);
	
}
