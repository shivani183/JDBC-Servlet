package ineuron;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class TestApp {
	public static void main(String[] args) {
		
		
		String configFile="/Users/avinashsingh/eclipse-workspace_2022/Hikari_CP_ConnectionPoolingApp2/src/ineuron/db.properties";
		HikariConfig config=new HikariConfig(configFile);
		
		
		
		//getting connection object from connection pool
		
		try (HikariDataSource datasource = new HikariDataSource(config)) {
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
