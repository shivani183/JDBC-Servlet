package CLOB;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CLOB_Insert {
	public static void main(String[] args) {
		Connection connection =null;
		PreparedStatement ptmt= null;
		String name=null;
		String docLoc=null;
		Scanner scan=new Scanner(System.in);
		try {
			connection=Jdbc_Util.jdbcSetConnection();
			String sqlInsert="insert into users(`name`,`doc`)values(?,?)";
			if(connection!=null) { 
				ptmt=connection.prepareStatement(sqlInsert);}
			if(ptmt!=null) {
				System.out.println("enter name");
				name=scan.next();
				
				System.out.println("enter doc location");
				docLoc=scan.next();
				ptmt.setString(1, name);
				ptmt.setCharacterStream(2, new FileReader(new File(docLoc)));
				
				int result=ptmt.executeUpdate();
				System.out.println("insertion happen in line "+result);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				Jdbc_Util.cleanUp(connection, ptmt, null);
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}

}
