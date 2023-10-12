package BATCH;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BATCH_UPDATE_PREPARED_stmt {
	public static void main(String[] args) {
		Connection connection =null;
		PreparedStatement ptmt= null;
		Scanner scan=null;
		String name=null;
		Integer age=0;
		String address=null;
		String sqlInsert="insert into employee(name,age,address)values(?,?,?)";
		
		try {
			connection=Jdbc_Util.jdbcSetConnection();
			if(connection!=null) {
				ptmt=connection.prepareStatement(sqlInsert);
			}
			if(ptmt!=null) {
				scan=new Scanner(System.in);
				while(true) {
					System.out.println("enter name");
					name=scan.next();
					System.out.println("enter age");
					age=scan.nextInt();
					System.out.println("enter address");
					address=scan.next();
					
					ptmt.setString(1, name);
					ptmt.setInt(2, age);
					ptmt.setString(3, address);
					
					ptmt.addBatch();
					
					System.out.print("If you want to add more data enter [yes/no] :: " );
					String input=scan.next();
					if(input.equalsIgnoreCase("no"))
						break;	
				}
				
				//OUTSIDE WHILE LOOP
				// exectuting queries one by one from batch
				ptmt.executeBatch();
				System.out.println("Record inserted successfully");
				
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
