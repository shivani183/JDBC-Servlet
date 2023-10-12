package InsertionApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertionApp {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement ptmt=null;
		Scanner scan=new Scanner(System.in);
		String name=null;
		String DOB=null;
		String DOM=null;
		java.sql.Date sDOM=null;
		java.sql.Date sDOB=null;
		try {
			connection=Jdbc_Util.jdbcSetConnection();
			String sqlInsert="insert into teacher(`name`,`DOB`,`DOM`) values (?,?,?)";
			
			if(connection!=null) {
				ptmt=connection.prepareStatement(sqlInsert);
			}
			if(ptmt!=null) {
				System.out.println("Enter the name-");
				name=scan.next();
				System.out.println("Enter DOB in dd-MM-yyyy format-");
				DOB=scan.next();
				System.out.println("Enter DOM in yyyy-MM-dd format-");
				DOM =scan.next();
				
				//changing DOB in sql format
				if(DOB!=null) {
					SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
					java.util.Date uDOB=sdf.parse(DOB);
					long l=uDOB.getTime();
					sDOB=new java.sql.Date(l);
					}
				//working on DOM
				if(DOM!=null)
					sDOM= java.sql.Date.valueOf(DOM);
				
				ptmt.setString(1, name);
				ptmt.setDate(2, sDOB);
				ptmt.setDate(3, sDOM);
				
				int result=ptmt.executeUpdate();
				System.out.println("insertion done in line "+result);
			}	
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				Jdbc_Util.cleanUp(connection, ptmt, null);
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
