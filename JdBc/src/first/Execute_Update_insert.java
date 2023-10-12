package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute_Update_insert {

	public static void main(String[] args) throws SQLException {
		System.out.println("Driver loaded");
		String url="jdbc:mysql:///school";
		String userName="root";
		String passWord="Shivani123";
		Connection connection=DriverManager.getConnection(url, userName, passWord);
		System.out.println("connection obj done");
		Statement statement=connection.createStatement();
		System.out.println("statement obj done");
		
		String sqlUpdateQuery="insert into student(fname,lname,city,age) values('nishu','singh','allha',28)";
		int update=statement.executeUpdate(sqlUpdateQuery);
		
		System.out.println(update);
		
		statement.close();
		connection.close();
		System.out.println("closing all connections");

	}

}
