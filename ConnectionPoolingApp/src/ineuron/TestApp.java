package ineuron;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class TestApp {
	public static void main(String[] args) {
		
		
		//create an object of a class which implements javax.sql.DataSource
		
		MysqlConnectionPoolDataSource datasource= new MysqlConnectionPoolDataSource();
		datasource.setUrl("jdbc:mysql:///school");
		datasource.setUser("root");
		datasource.setPassword("Shivani123");
		
		//getting connection object from connection pool
		
		try {
			Connection connect=datasource.getConnection();
			Statement stmt=connect.createStatement();
			ResultSet resultset=stmt.executeQuery("select * from student");
			while(resultset.next()) {
				System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)
				+"\t"+resultset.getInt(4)+"\t"+resultset.getInt(5));
			}
			//sending connection obj. back to the connection pool
			connect.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
