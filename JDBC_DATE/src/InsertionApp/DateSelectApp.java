package InsertionApp;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateSelectApp {

	public static void main(String[] args) {
		Connection connect=null;
		PreparedStatement ptmt=null;
		int id=0;
		ResultSet resultSet=null;
		Scanner scan = new Scanner(System.in);
		
		try {
			connect=Jdbc_Util.jdbcSetConnection();
			
			String sqlSelect="select * from teacher where id=?";
			if(connect!=null) {
				ptmt=connect.prepareStatement(sqlSelect);
				System.out.println("enter id");
				id=scan.nextInt();	
			}
			if(ptmt!=null) {
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
			}
			if(resultSet!=null) {
				if(resultSet.next()) {
					int sid=resultSet.getInt(1);
					String name=resultSet.getString(2);
					java.sql.Date DOB= resultSet.getDate(3);
					java.sql.Date DOM= resultSet.getDate(4);
					System.out.println("id\tname\tDOB\t\tDOM");
					
					SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
					String frDOB=sdf.format(DOM);
					String frDOM=sdf.format(DOB);
					System.out.println(sid+"\t"+name+"\t"+frDOB+"\t"+frDOM);
				}
			}
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				Jdbc_Util.cleanUp(connect, ptmt, resultSet);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
