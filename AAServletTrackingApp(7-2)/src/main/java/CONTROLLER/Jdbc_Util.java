package CONTROLLER;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc_Util {
	private Jdbc_Util() {
		
	}

		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Driver loaded");
		}
	public static void cleanUp(Connection connection,Statement statement,ResultSet resultSet) throws SQLException {
		if(connection!=null) 
			connection.close();
		
		if(statement!=null)
			statement.close();
		if(resultSet!=null)
			resultSet.close();
	}

	public static Connection jdbcSetConnection() throws SQLException, IOException {
		
		FileInputStream fis=new FileInputStream("/Users/avinashsingh/eclipse-workspace_2022/AAServletTrackingApp(7-2)/src/main/java/application.properties");
		Properties properties= new Properties();
		properties.load(fis);

		Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"), properties.getProperty("passWord"));
		
		System.out.println("connection obj created");
		return connection;
		
	}
	
}
