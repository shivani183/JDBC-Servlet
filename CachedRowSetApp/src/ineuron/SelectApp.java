package ineuron;

import java.sql.SQLException;


import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class SelectApp {
	public static void main(String[] args) throws SQLException {
		
	
		RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet jrs=rsf.createCachedRowSet();
		jrs.setUrl("jdbc:mysql:///school");
		jrs.setUsername("root");
		jrs.setPassword("Shivani123");
		
		jrs.setCommand("select * from student");
		jrs.execute();
		System.out.println("printing in acending");
		while(jrs.next()) {
			System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+
		jrs.getInt(4)+"\t"+jrs.getInt(5));
		}
		System.out.println();
		System.out.println("printing in decending");
		while(jrs.previous()) {
			System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+
		jrs.getInt(4)+"\t"+jrs.getInt(5));
		}
		System.out.println();
		jrs.beforeFirst();
		jrs.absolute(2);
		System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+
				jrs.getInt(4)+"\t"+jrs.getInt(5));
		jrs.relative(-1);
		System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+
				jrs.getInt(4)+"\t"+jrs.getInt(5));
		
	}

}
