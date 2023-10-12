package RESULTSET_Scroll;

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

public class ResultSet_Nonscrollable {

	public static void main(String[] args) {
		Connection connection=null;
		Statement stmt=null;
		ResultSet resultSet =null;
		Scanner scan=new Scanner(System.in);
		
		try {
			System.out.println("Balance before transaction");
			connection=Jdbc_Util.jdbcSetConnection();
			
			if(connection!=null) {
				//ResultSet is scrollable and updatable
				stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			}if(stmt!=null) {
					resultSet=stmt.executeQuery("select * from student");
			}if(resultSet!=null) {
				System.out.println("moving in forward direction");
				System.out.println("ID\tNAME\tCITY\t\tage");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
				     resultSet.getString(3)+"\t\t"+resultSet.getInt(4));
				}
				System.out.println();
				System.out.println("moving in forward direction");
				System.out.println("ID\tNAME\tCITY\t\tage");
				while(resultSet.previous()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
				     resultSet.getString(3)+"\t\t"+resultSet.getInt(4));
				}
				System.out.println();
				resultSet.first();
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
					     resultSet.getString(3)+"\t\t"+resultSet.getInt(4));
				
				System.out.println();
				resultSet.last();
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
					     resultSet.getString(3)+"\t\t"+resultSet.getInt(4));

				System.out.println();
				resultSet.first();
				//absolute is including current jump to 3rd
				resultSet.absolute(3);
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
					     resultSet.getString(3)+"\t\t"+resultSet.getInt(4));
				
				System.out.println();
				//relative is excluding current jump to 4th
				resultSet.relative(4);
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
					     resultSet.getString(3)+"\t\t"+resultSet.getInt(4));
				
				System.out.println();
				//relative(-1) will move to backward direction 
				resultSet.relative(-1);
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
					     resultSet.getString(3)+"\t\t"+resultSet.getInt(4));
				
				System.out.println();
				resultSet.first();
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
					     resultSet.getString(3)+"\t\t"+resultSet.getInt(4));
				
				//if at first and doing absolute(-1) it will go to last record
				//if at last and doing absolute(1) it will go to first record
				//if at first and doing relative(-1) result if runtime exception;
				//if at last and doing relative(1) result if runtime exception;
				
				resultSet.absolute(-4);
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
					     resultSet.getString(3)+"\t\t"+resultSet.getInt(4));
				
				
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
