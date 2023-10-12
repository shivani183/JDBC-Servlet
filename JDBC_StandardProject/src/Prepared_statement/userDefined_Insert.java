package Prepared_statement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class userDefined_Insert {

	public static void main(String[] args){
		Connection connection=null;
		PreparedStatement ptmt=null;
		Scanner scan=new Scanner(System.in);
		
		try {
			connection = Jdbc_Standard.Jdbc_Util.jdbcSetConnection();
			if(connection!=null) {
				connection.prepareCall(null);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				Jdbc_Standard.Jdbc_Util.cleanUp(connection, ptmt, null);
				scan.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}

	}

}
