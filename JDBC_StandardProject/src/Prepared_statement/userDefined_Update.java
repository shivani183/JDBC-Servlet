package Prepared_statement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Jdbc_Standard.Jdbc_Util;

public class userDefined_Update {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement ptmt=null;
		PreparedStatement ptmt1=null;
		ResultSet resultSet=null;
		Scanner scan=null;
		
		try {
			connection=Jdbc_Standard.Jdbc_Util.jdbcSetConnection();
			String sqlUpdate="Update student set name=? where id=?";
			
			if(connection!=null) {
				ptmt=connection.prepareStatement(sqlUpdate);
			}
			if(ptmt!=null) {
				scan=new Scanner(System.in);
				System.out.println("enter id");
				Integer id=scan.nextInt();	
				System.out.println("Enter new Name--");
				String name=scan.next();
				ptmt.setInt(2, id);
				ptmt.setString(1, name);
				int smart=ptmt.executeUpdate();
				System.out.println(smart);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
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
