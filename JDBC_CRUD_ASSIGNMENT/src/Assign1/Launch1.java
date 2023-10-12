package Assign1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Launch1 {

	private Launch1() {};
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	
	public static Connection setConnection() throws SQLException, IOException{
		FileInputStream fis= new FileInputStream("/Users/avinashsingh/eclipse-workspace_2022/JDBC_ASSIGNMENT/Pkg.properties");
		
		Properties properties= new Properties();
		properties.load(fis);
		
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("userName"),properties.getProperty("passWord"));
		
		return connection;				
	}
	public static void CleanUp(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if(connection!=null) 
				connection.close();
			if(statement!=null) 
				statement.close();
			if(resultSet!=null) 
				resultSet.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
