package Krishna_Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/util")
public class Jdbc_Util extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Jdbc_Util() {};
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
	
	FileInputStream fis=new FileInputStream("/Users/avinashsingh/eclipse-workspace_2022/JDBC_CRUD_APP/src/properties/application_without_hikari.properties");
	Properties properties= new Properties();
	properties.load(fis);
	
	
	Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"), properties.getProperty("passWord"));
			

	return connection;
	
}

}
