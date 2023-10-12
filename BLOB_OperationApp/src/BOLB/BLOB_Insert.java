package BOLB;


import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BLOB_Insert {
	public static void main(String[] args) {
		Connection connection =null;
		PreparedStatement ptmt= null;
		String name=null;
		String imageLoc=null;
		String videoLoc=null;
		Scanner scan=new Scanner(System.in);
		try {
			connection=Jdbc_Util.jdbcSetConnection();
			String sqlInsert="insert into persons(`name`,`image`,`videofile`)"
					+ "values(?,?,?)";
			if(connection!=null) { 
				ptmt=connection.prepareStatement(sqlInsert);}
			if(ptmt!=null) {
				System.out.println("enter name");
				name=scan.next();
				
				System.out.println("enter image location");
				imageLoc=scan.next();
				
				System.out.println("enter video location");
				videoLoc=scan.next();
				
				ptmt.setString(1, name);
				ptmt.setBinaryStream(2, new FileInputStream(new File(imageLoc)));
				ptmt.setBinaryStream(3, new FileInputStream(new File(videoLoc)));
				
				
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
