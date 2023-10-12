package TRANNSACTION;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import SAVE_POINT_TRAN.Jdbc_Util;

public class TransactionApp {

	public static void main(String[] args) {
		Connection connection=null;
		Statement stmt=null;
		ResultSet resultSet =null;
		Scanner scan=new Scanner(System.in);
		
		try {
			System.out.println("Balance before transaction");
			connection=Jdbc_Util.jdbcSetConnection();
			String sqlQuery="select name, balance from accounts";
			if(connection!=null) {
				stmt=connection.createStatement();
			}
			if(stmt!=null) {
				resultSet = stmt.executeQuery(sqlQuery);
			}
			if(resultSet!=null) {
				System.out.println("Name\tBalance");
				while(resultSet.next()) {
					System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
				}
			}
			System.out.println("Transaction Begins");
			
			connection.setAutoCommit(false);
			
			stmt.executeUpdate("update accounts set balance=balance-5000 where name ='sachin'");
			stmt.executeUpdate("update accounts set balance= balance+5000 where name ='avi'");
			System.out.println("please confirm for transaction of 5000 [yes/no]");
			String input =scan.next();
			
			if(input.equalsIgnoreCase("yes")) 
				connection.commit();
			else
				connection.rollback();
			
			System.out.println("Balance after transaction");
			ResultSet rs=stmt.executeQuery("select name, balance from accounts");
			if(rs!=null) {
				System.out.println("Name\tBalance");
				while(rs.next()) {
					System.out.println(rs.getString(1)+"\t"+rs.getString(2));
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
