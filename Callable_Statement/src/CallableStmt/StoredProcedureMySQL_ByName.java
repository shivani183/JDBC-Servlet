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

public class StoredProcedureMySQL_ByName {
	
	private static final String SqlStoredProcedure="{CALL GET_PRODUCTS_BY_NAME(?,?)}";
	

	public static void main(String[] args) {
		Connection connection =null;
		CallableStatement cltmt= null;
		Scanner scan=new Scanner(System.in);
		String prd1=null;
		String prd2=null;
		ResultSet resultSet=null;
		boolean flag =false;
		
		try {
			connection=Jdbc_Util.jdbcSetConnection();
			if(connection!=null) {
				
				cltmt=connection.prepareCall(SqlStoredProcedure);
			}
			if(scan!=null) {
				System.out.println("enter name1");
				prd1=scan.next();	
				System.out.println("enter name2");
				prd2=scan.next();	
			}
			
			//setting input values
			if(cltmt!=null) {
				cltmt.setString(1, prd1);
				cltmt.setString(2, prd2);}
			if(cltmt!=null) {
				cltmt.execute();
				resultSet=cltmt.getResultSet();
			}
			if(resultSet!=null) {
				System.out.println("id\tname\tcost\tquantity");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
							resultSet.getInt(3)+"\t"+resultSet.getInt(4));
					flag=true;
				}
			}
			if(flag==true)
				System.out.println("Record available");
			else
				System.out.println("Record not available");
			
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				Jdbc_Util.cleanUp(connection, cltmt, resultSet);
				scan.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}

}
