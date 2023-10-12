package ineuron;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class DeleteApp {
	public static void main(String[] args) throws SQLException {
		
		Connection connect=DriverManager.getConnection("jdbc:mysql:///school", "root", "Shivani123");
		connect.setAutoCommit(false);
		Statement stmt=connect.createStatement();
		ResultSet resultset=stmt.executeQuery("select * from student");
		
		
		RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet jrs=rsf.createCachedRowSet();
		jrs.populate(resultset);
		
		while(jrs.next()) {
			int currentsalary=jrs.getInt(5);
			if(currentsalary<4000&& currentsalary>1000) {
				jrs.deleteRow();
			}
			
		}
		
		jrs.moveToCurrentRow();
		jrs.acceptChanges();
		jrs.commit();
		System.out.println("successfully deleted");
		jrs.close();
		
	}

}
