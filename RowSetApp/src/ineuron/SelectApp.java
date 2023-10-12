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
		
		
		
		/*
		 * CachedRowSet crs=rsf.createCachedRowSet(); FilteredRowSet
		 * frs=rsf.createFilteredRowSet(); JdbcRowSet jrs=rsf.createJdbcRowSet();
		 * JoinRowSet jnrs=rsf.createJoinRowSet(); WebRowSet wrs=rsf.createWebRowSet();
		 * 
		 * System.out.println(rsf.getClass().getName());
		 * System.out.println(crs.getClass().getName());
		 * 
		 * System.out.println(frs.getClass().getName());
		 * 
		 * System.out.println(jrs.getClass().getName());
		 * System.out.println(jnrs.getClass().getName());
		 * System.out.println(wrs.getClass().getName());
		 */
		
		RowSetFactory rsf=RowSetProvider.newFactory();
		JdbcRowSet jrs=rsf.createJdbcRowSet();
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
		jrs.absolute(3);
		System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+
				jrs.getInt(4)+"\t"+jrs.getInt(5));
		jrs.relative(-2);
		System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+
				jrs.getInt(4)+"\t"+jrs.getInt(5));
		
	}

}
