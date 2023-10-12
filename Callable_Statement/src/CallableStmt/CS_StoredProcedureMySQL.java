package CallableStmt;

/*
 * DELIMITER $$

USE `school`$$
CREATE PROCEDURE `GET_PRODUCTS_DETAILS_BY_ID` (IN ID INT,OUT NAME VARCHAR(30),OUT RATE INT, OUT QNT INT)
BEGIN
SELECT pname, price, quantity INTO NAME,RATE,QNT FROM PRODUCTS WHERE PID =ID; 
END$$
*/

import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CS_StoredProcedureMySQL {
	
	private static final String SqlStoredProcedure="{CALL GET_PRODUCTS_DETAILS_BY_ID(?,?,?, ?)}";

	public static void main(String[] args) {
		Connection connection =null;
		CallableStatement cltmt= null;
		Scanner scan=new Scanner(System.in);
		Integer id=0;
		
		try {
			connection=Jdbc_Util.jdbcSetConnection();
			if(connection!=null) {
				
				cltmt=connection.prepareCall(SqlStoredProcedure);
			}
			if(scan!=null) {
				System.out.println("enter id");
				id=scan.nextInt();			
			}
			//setting input values
			if(cltmt!=null) {
				cltmt.setInt(1, id);
				//Registering output values, setting output values
				cltmt.registerOutParameter(2, Types.VARCHAR);
				cltmt.registerOutParameter(3, Types.INTEGER);
				cltmt.registerOutParameter(4, Types.INTEGER);
			}
			if(cltmt!=null) {
				//executing values
				cltmt.execute();
				
				//retrieving values
				System.out.println("product name is ::" + cltmt.getString(2));
				System.out.println("product rate is ::" + cltmt.getInt(3));
				System.out.println("product quantity is ::" + cltmt.getInt(4));
			}
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				Jdbc_Util.cleanUp(connection, cltmt, null);
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}

}
