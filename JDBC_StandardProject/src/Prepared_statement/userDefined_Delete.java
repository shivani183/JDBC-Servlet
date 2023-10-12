package Prepared_statement;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import Jdbc_Standard.Jdbc_Util;

public class userDefined_Delete {

	public static void main(String[] args) {
		Connection connect=null;
		Scanner scan=null;
		PreparedStatement ptmt=null;
		String sqlDeteleQuery=null;
		Integer id=0;
		
		try {
				connect = Jdbc_Util.jdbcSetConnection();
				
				String sqlDeleteQuery = "delete from student where id = ?";
				if (connect != null) {
					ptmt = connect.prepareStatement(sqlDeleteQuery);
				}
				if (ptmt != null) {
						scan = new Scanner(System.in);

						System.out.print("Enter the id of the student :: ");
						id= scan.nextInt();

						// use precompiled query to set the values
						ptmt.setInt(1, id);

						// execute the query
						int rowCount = ptmt.executeUpdate();
						System.out.println("No of rows deleted is :: " + rowCount);
					}

		}catch(SQLException w) {
			w.printStackTrace();
		}catch(IOException w) {
			w.printStackTrace();
		}finally {
			try {
				Jdbc_Util.cleanUp(connect, ptmt, null);
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		

	}

}
