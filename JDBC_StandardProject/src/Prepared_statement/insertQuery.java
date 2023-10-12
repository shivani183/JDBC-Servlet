package Prepared_statement;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Jdbc_Standard.Jdbc_Util;

public class insertQuery {
	public static void main(String[] args) throws SQLException, IOException {
		Connection connection = null;
		PreparedStatement ptmt=null;
		
		try {
			connection=Jdbc_Standard.Jdbc_Util.jdbcSetConnection();
			String sqlInsertQuery = "insert into student(fname,lname,city,age) values"
					+ "(?,?,?,?)";
			if(connection!=null) 
				ptmt=connection.prepareStatement(sqlInsertQuery);
			
			if(ptmt!=null) {
				ptmt.setString(1, "abhi");
				ptmt.setString(2, "dubey");
				ptmt.setString(3, "blr");
				ptmt.setInt(4, 34);
			}
			int row=ptmt.executeUpdate();
			System.err.println(row);
		}finally {
			try {
				Jdbc_Util.cleanUp(connection, ptmt, null);
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
		
	}
}

