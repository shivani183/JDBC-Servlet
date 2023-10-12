package ineuron;

import java.io.FileWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;



public class TestApp {

	public static void main(String[] args) throws Exception {
		Connection connection= DriverManager.getConnection("jdbc:mysql:///school","root","Shivani123");
		Statement stmt=connection.createStatement();
		ResultSet resultset=stmt.executeQuery("select *  from student");
		
		RowSetFactory rsf=RowSetProvider.newFactory();
		WebRowSet crs=rsf.createWebRowSet();
		
		crs.populate(resultset);
		connection.close();
			
		while(crs.next()) {
			System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getString(3)
			+"\t"+crs.getInt(4)+"\t"+crs.getInt(5));
		}
		
		//sending it to network
		FileWriter fw=new FileWriter("sdt.xml");
		crs.writeXml(fw);
		System.out.println("its done");
		fw.close();
		

	}

}
