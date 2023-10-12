package Krishna_persistence;

import java.io.IOException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import Krishna_Util.Jdbc_Util;
import Krishna_dto.Student;
import Krishna_persistence.IStudentDao;

@WebServlet("/daoImpl")
public class StudentDaoImpl implements IStudentDao  {

	Connection connection=null;
	PreparedStatement ptmt=null;
	ResultSet resultSet=null;
	Student student=null;
	
	
	public String addStudent(Student student) {
		try {
			String sqlInsert="insert into student(`name`,`city`,`age`)values(?,?,?)";
			connection=Jdbc_Util.jdbcSetConnection();
			if(connection!=null) {
				ptmt=connection.prepareStatement(sqlInsert);
			}
			if(ptmt!=null) {
				ptmt.setString(1,student.getName());
				ptmt.setString(2, student.getCity());
				ptmt.setInt(3, student.getAge());
				
				int result=ptmt.executeUpdate();
				if(result==1)
					return "success";
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
		
	}

	public Student searchStudent(Integer id) {
		String sqlSelect="select * from student where id=?";
		try {
			connection=Jdbc_Util.jdbcSetConnection();
			if(connection!=null) {
				ptmt=connection.prepareStatement(sqlSelect);
			}
			if(ptmt!=null) {
				ptmt.setInt(1, id);
			}if(ptmt!=null) {
				resultSet=ptmt.executeQuery();
			}
			if(resultSet!=null) {
				Student student=null;
				if(resultSet.next()) {
					student=new Student();
					student.setId(resultSet.getInt(1));
					student.setName(resultSet.getString(2));
					student.setCity(resultSet.getString(3));
					student.setAge(resultSet.getInt(4));
					
					return student;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return student;
	}
	


	public String deleteStudent(Integer id) {
		try {
			String sqlDelete="delete from student where id=?";
			connection=Jdbc_Util.jdbcSetConnection();
			if(connection!=null) {
				ptmt=connection.prepareStatement(sqlDelete);
			}
			if(ptmt!=null) {
				
				ptmt.setInt(1, id);
				
				int result=ptmt.executeUpdate();
				if(result==1)
					return "success";
				else
					return "not found";
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
		
	}
	public String updateStudent(Student student) {
		String sqlUpdateQuery="update student set name=?,city=?, age=? where id =?;";
		try {
			connection = Jdbc_Util.jdbcSetConnection();

			if (connection != null)
				ptmt = connection.prepareStatement(sqlUpdateQuery);

			if (ptmt != null) {

				ptmt.setString(1, student.getName());
				ptmt.setString(2, student.getCity());
				ptmt.setInt(3, student.getAge());
				
				ptmt.setInt(4, student.getId());

				int rowAffected = ptmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";	
	}
}
