package ineuron;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class InsertApp {
	public static void main(String[] args) throws SQLException {
		RowSetFactory rsf=RowSetProvider.newFactory();
		JdbcRowSet jrs=rsf.createJdbcRowSet();
		jrs.setUrl("jdbc:mysql:///school");
		jrs.setUsername("root");
		jrs.setPassword("Shivani123");
		
		jrs.setCommand("select * from student");
		jrs.execute();
		Scanner scan = new Scanner(System.in);
		
		jrs.moveToInsertRow();
		while(true) {
			System.out.print("Enter the name::");
			String name = scan.next();

			System.out.print("Enter the age::");
			Integer age = scan.nextInt();

			System.out.print("Enter the city::");
			String city = scan.next();

			jrs.updateString(2, name);
			jrs.updateString(3, city);
			jrs.updateInt(4, age);

			jrs.insertRow();

			System.out.println("Record inserted succesfully.....");
			System.out.print("Do u want to insert one more record [Yes/No]::  ");
			String option = scan.next();
			if (option.equalsIgnoreCase("No")) {
				break;
			}
		}
		scan.close();
		jrs.close();
		
	}

}
