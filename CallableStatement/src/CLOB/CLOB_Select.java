package CLOB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;

public class CLOB_Select {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection connection=null;
		CallableStatement cstmt= null;
		ResultSet resultSet=null;
		Integer id=0;
		Scanner scan = null;
		
		try {
			connection = Jdbc_Util.jdbcSetConnection();
			if (connection != null)
				cstmt = connection.prepareCall(storedProcedureCall);

			scanner = new Scanner(System.in);
			if (scanner != null) {
				System.out.print("Enter the product id :: ");
				id = scanner.nextInt();
			}

			// Setting the input values
			if (cstmt != null) {
				cstmt.setInt(1, id);
			}

			// Setting the Datetype of output values
			if (cstmt != null) {
				cstmt.registerOutParameter(2, Types.VARCHAR);
				cstmt.registerOutParameter(3, Types.INTEGER);
				cstmt.registerOutParameter(4, Types.INTEGER);
			}

			// run the stored procedure
			if (cstmt != null) {
				cstmt.execute();
			}

			// retreive the result
			if (cstmt != null) {
				System.out.println("Product Name is :: " + cstmt.getString(2));
				System.out.println("Product Cost is :: " + cstmt.getInt(3));
				System.out.println("Product QTY  is :: " + cstmt.getInt(4));
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
