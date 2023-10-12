package SAVE_POINT_TRAN;

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

public class Trans_savePoint {

	public static void main(String[] args) {
		Connection connection=null;
		Statement stmt=null;
		ResultSet resultSet =null;
		Scanner scan=new Scanner(System.in);
		
		try {
			System.out.println("Balance before transaction");
			connection=Jdbc_Util.jdbcSetConnection();
			
			if(connection!=null) {
				stmt=connection.createStatement();
			}if(stmt!=null) {
				connection.setAutoCommit(false);
				System.out.println("insertion start");
				stmt.executeUpdate("insert into politics(name,party)values ('yogi','BJP')");
				stmt.executeUpdate("insert into politics(name,party)values ('priyanka','CONGRESS')");
				Savepoint sp=connection.setSavepoint();
				stmt.executeUpdate("insert into politics(name,party)values ('mamta','TRC')");
				
				connection.rollback(sp);
				connection.commit();
				
				System.out.println("insertion success...");
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
