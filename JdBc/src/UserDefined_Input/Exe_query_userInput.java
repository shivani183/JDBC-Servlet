package UserDefined_Input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exe_query_userInput {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		String url="jdbc:mysql:///school";
		String userName="root";
		String passWord="Shivani123";
		Scanner scan= new Scanner(System.in);
		
		System.out.println("please enter first name-");
		String fname=scan.next();
		
		System.out.println("please enter last name-");
		String lname=scan.next();
		
		System.out.println("please enter city-");
		String city=scan.next();
		
		System.out.println("please enter age-");
		Integer age=scan.nextInt();

		Connection connection= DriverManager.getConnection(url, userName, passWord);
		System.out.println("got connection obj");
        Statement statement=connection.createStatement();
        System.out.println("got statement obj");
        
        //String newSql="insert into student (`fname`,`lname`,`city`,`age`)values('"+fname+"','"+lname+"','"+city+"',"+age+")";
 
        String newSql=String.format("insert into student (`fname`,`lname`,`city`,`age`)values('%s','%s','%s',%d)",fname,lname,city,age);
        System.out.println(newSql);
        int samosa=statement.executeUpdate(newSql);
        System.out.println(samosa);
       
        
		
		statement.close();
		connection.close();
		scan.close();
		
		
	}

}
