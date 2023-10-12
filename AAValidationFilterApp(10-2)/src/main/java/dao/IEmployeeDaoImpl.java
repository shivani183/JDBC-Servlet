package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.Employee;

public class IEmployeeDaoImpl implements IEmployeeDao {

	private static final String sqlQuery = "insert into employees(eid,ename,eage,email,mobile)values(?,?,?,?,?)";

	@Override
	public String insert(Employee employee) {

		PreparedStatement ptmt = null;
		Connection connection = null;
		String status = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql:///school", "root", "Shivani123");
				if (connection != null)
					ptmt = connection.prepareStatement(sqlQuery);
				if (ptmt != null) {
					ptmt.setString(1, employee.getEid());
					ptmt.setString(2, employee.getEname());
					ptmt.setInt(3, employee.getEage());
					ptmt.setString(4, employee.getEmail());
					ptmt.setString(5, employee.getMobile());

					int rowCount = ptmt.executeUpdate();
					if (rowCount == 1) {
						status = "success";
					} else {
						status = "failure";
					}
				}
			}

		catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	return null;
	
}
}