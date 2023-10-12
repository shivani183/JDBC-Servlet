package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import dto.Politics;
import dto.Student;

import java.sql.ResultSet;
import java.sql.SQLException;


import util.JdbcUtil;

public class PoliticsDaoImpl implements IPoliticsDao{
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultSet = null;
	
	@Override
	public String addPolitics(Politics politics) {

		String sqlInsertQuery = "insert into politics(`name`,`party`,`expert`)"
				+ "values('\"+Pname+\"','\"+Pparty+\"',\"+Pexpert+\")";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				stmt = connection.createStatement();
			
				stmt.setString(1, politics.getPname());
				stmt.setInt(2, politics.getPexpert());
				stmt.setString(3, politics.getPparty());

				int rowAffected = stmt.executeUpdate(sqlInsertQuery);
				if (rowAffected == 1) {
					return "success";
				
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}
	
	@Override
	public Politics searchPolitics(Integer sid) {
		String sqlSelectQuery = "select name,party,expert,id from politics where id = \"+Pid+\"";
		Politics politics = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				stmt = connection.createStatement();

			if (stmt != null)
				stmt.setInt(1, pid);

			if (stmt != null) {
				resultSet = stmt.executeQuery(sqlSelectQuery);
			}

			if (resultSet != null) {

				if (resultSet.next()) {
					politics = new Politics();

					// copy resultSet data to student object
					politics.setPid(resultSet.getInt(1));
					politics.setPname(resultSet.getString(2));
					politics.setPexpert(resultSet.getInt(3));
					politics.setPparty(resultSet.getString(4));

					return politics;
				}

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return politics;
	}
	@Override
	public String deletePolitics(Integer pid) {
		String sqlDeleteQuery = "delete from politics where id =\"+Pid+\"";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				stmt = connection.createStatement();

			if (stmt != null) {

				stmt.setInt(1, pid);

				int rowAffected = stmt.executeUpdate(sqlDeleteQuery);
				if (rowAffected == 1) {
					return "success";
				} else {
					return "not found";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}
	
	public String updatePolitics(Politics politics){
		String sqlUpdateQuery = "update politics set name='\"+Pname+\"',party='\"+Pparty+\"',expert=\"+Pexpert+\" where id=\"+Pid+\"";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				stmt = connection.createStatement();

			if (stmt != null) {

				stmt.setString(1, politics.getPname());
				stmt.setInt(2, politics.getPexpert());
				stmt.setString(3, politics.getPparty());
				stmt.setInt(4, politics.getPid());

				int rowAffected = stmt.executeUpdate(sqlUpdateQuery);
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




