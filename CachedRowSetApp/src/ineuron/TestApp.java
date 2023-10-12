package ineuron;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;



public class TestApp {

	public static void main(String[] args) throws Exception {
		Connection connection= DriverManager.getConnection("jdbc:mysql:///school","root","Shivani123");
		Statement stmt=connection.createStatement();
		ResultSet resultset=stmt.executeQuery("select *  from student");
		
		RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet crs=rsf.createCachedRowSet();
		
		crs.populate(resultset);
		connection.close();
			
		while(crs.next()) {
			System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getString(3)
			+"\t"+crs.getInt(4)+"\t"+crs.getInt(5));
		}
		

	}

}
