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

public class UpdateApp {
	public static void main(String[] args) throws SQLException {
		RowSetFactory rsf=RowSetProvider.newFactory();
		JdbcRowSet jrs=rsf.createJdbcRowSet();
		jrs.setUrl("jdbc:mysql:///school");
		jrs.setUsername("root");
		jrs.setPassword("Shivani123");
		
		jrs.setCommand("select * from student");
		jrs.execute();
		
		while(jrs.next()) {
			int currentsalary=jrs.getInt(5);
			if(currentsalary<5000) {
				int updatedsalary = currentsalary+1000;
				jrs.updateInt(5, updatedsalary);
				jrs.updateRow();
			}
			
		}
		
		
		jrs.close();
		
	}

}
