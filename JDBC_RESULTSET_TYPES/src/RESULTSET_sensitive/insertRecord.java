package RESULTSET_sensitive;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class insertRecord {

	public static void main(String[] args) {
		Connection connection=null;
		Statement stmt=null;
		ResultSet resultSet =null;
		Scanner scan=new Scanner(System.in);
		
		try {
			
			connection=Jdbc_Util.jdbcSetConnection();
			if (connection != null)
				// Expecting ResultSet to be SCROLLABLE AND UPDATABLE
				stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String sqlQuery = "select id,name,city,age from student";

			if (stmt != null)
				resultSet = stmt.executeQuery(sqlQuery);

			if (resultSet != null) {
				System.out.println("Records before insertion....");
				System.out.println("ID\tNAME\tcity\tage");
				while (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
							+ "\t" + resultSet.getInt(4));
				}

				resultSet.moveToInsertRow();
				
				resultSet.updateString(2, "rohith");
				resultSet.updateString(3, "MI");
				resultSet.updateInt(4, 38);
				resultSet.insertRow();

				System.out.println();
				resultSet.beforeFirst();// taking the cursor to BFR
				System.out.println("Records after insertion....");
				System.out.println("ID\tNAME\tcity\tAge");
				while (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
							+ "\t" + resultSet.getInt(4));
				}
			}
			
				
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				Jdbc_Util.cleanUp(connection, stmt, resultSet);
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
