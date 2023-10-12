package Prepared_statement;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Jdbc_Standard.Jdbc_Util;

import java.sql.Connection;

public class userDefined_Select {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection connection=null;
		PreparedStatement ptmt= null;
		ResultSet resultSet=null;
		Integer id=0;
		Scanner scan = null;
		
		
		try {
		connection=Jdbc_Standard.Jdbc_Util.jdbcSetConnection();
		     
			if(connection!=null) {
				String sqlSelectQuery="Select * from student where id=?";
				ptmt=connection.prepareStatement(sqlSelectQuery);
			}
			if(ptmt!=null) {
				scan = new Scanner(System.in);
				System.out.println("please enter the id..");
				id=scan.nextInt();
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
			}
			
			if(resultSet!=null) {
				if(resultSet.next()) {
					System.out.println("id\tname\tcity\tage");
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getInt(4));
				}
				else {
					System.out.println("Result not found for ::" + id);
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally {
			Jdbc_Util.cleanUp(connection, ptmt, resultSet);
			scan.close();
		}
		
	}

}
