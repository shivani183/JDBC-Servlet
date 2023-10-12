package BATCH;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BATCH_UPDATE_STATEMENT {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Connection connection =null;
		Statement state= null;

		String sqlInsert="insert into employee(name,age,address)values('alka',26,'patna')";
		String sqlInsert1="insert into employee(name,age,address)values('ritika',25,'kashi')";
		String sqlInsert2="insert into employee(name,age,address)values('khushi',06,'delhi')";

		

		
		
		try {
			connection=Jdbc_Util.jdbcSetConnection();
			if(connection!=null) {
				state=connection.createStatement();
			}
			if(state!=null) {
					state.addBatch(sqlInsert2);
					state.addBatch(sqlInsert);
					state.addBatch(sqlInsert1);
							
				//OUTSIDE WHILE LOOP
				// exectuting queries one by one from batch
				state.executeBatch();
				System.out.println("Record inserted successfully");
				
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				Jdbc_Util.cleanUp(connection, state, null);
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}

}
