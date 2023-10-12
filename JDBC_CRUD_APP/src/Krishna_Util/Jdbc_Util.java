package Krishna_Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Jdbc_Util {

	private Jdbc_Util() {};
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//System.out.println("Driver loaded");
		}

	public static Connection jdbcSetConnection() throws SQLException, IOException {
		
		HikariConfig config= new HikariConfig("/Users/avinashsingh/eclipse-workspace_2022/JDBC_CRUD_APP/src/properties/application.properties");
		HikariDataSource dataSource=new HikariDataSource(config);
		return dataSource.getConnection();
		
	}

}
