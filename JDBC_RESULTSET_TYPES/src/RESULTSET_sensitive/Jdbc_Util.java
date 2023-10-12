package RESULTSET_sensitive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
	//Step 2: Connection obj created	
	public static void cleanUp(Connection connection,Statement statement,ResultSet resultSet) throws SQLException {
		if(connection!=null) 
			connection.close();
		
		if(statement!=null)
			statement.close();
		if(resultSet!=null)
			resultSet.close();
	}

	public static Connection jdbcSetConnection() throws SQLException, IOException {
		
		FileInputStream fis=new FileInputStream("/Users/avinashsingh/eclipse-workspace_2022/JDBC_StandardProject/application.properties");
		Properties properties= new Properties();
		properties.load(fis);
		
		//IN THE BELOW LINES WE ARE USING PROPERTIES FILES AND ALSO INLINE FORMAT OF WRITTING.
		
		Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"), properties.getProperty("passWord"));
				
		//IN THE BELOW LINES WE ARE CREATING CONNECTION OBJECT WITH USING PROPERTIES FILE.
		
//		String url=properties.getProperty("url");
//		String userName=properties.getProperty("userName");
//		String passWord=properties.getProperty("passWord");
//		Connection connection=DriverManager.getConnection(url, userName, passWord);
		
        //THERE ARE SEVERAL WAYS TO WRITE CONNCTION OBJECTS ONE IS THE BELOW PART WHICH CAN BE 
		//DONE WITHOUT PROPERTIES FILE		
		
//		String url="jdbc:mysql:///school";
//		String userName="root";
//		String passWord="Shivani123";
//		Connection connection=DriverManager.getConnection(url, userName, passWord);
		
		
		//System.out.println("connection obj created");
		return connection;
		
	}

}
