package BOLB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.*;
import java.sql.Connection;

public class BLOB_Select {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection connection=null;
		PreparedStatement ptmt= null;
		ResultSet resultSet=null;
		Integer id=0;
		Scanner scan = null;
		
		
		try {
		connection=Jdbc_Util.jdbcSetConnection();
		     
			if(connection!=null) {
				String sqlSelectQuery="Select * from persons where id=?";
				ptmt=connection.prepareStatement(sqlSelectQuery);
			}
			if(ptmt!=null) {
				scan = new Scanner(System.in);
				System.out.println("please enter the id..");
				id=scan.nextInt();
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
			}
			
			if(resultSet!=null) {
				if(resultSet.next()) {
					System.out.println("id\tname\timage");
					id=resultSet.getInt(1);
					String name=resultSet.getString(2);
					
					InputStream is=resultSet.getBinaryStream(3);
					File file=new File("shivi.jpg");
					FileOutputStream fos= new FileOutputStream(file);
					IOUtils.copy(is, fos);
					
					/* byte[] b= new byte[1024]; while(is.read(b)>0) { fos.write(b); } */
					/* int i=is.read(); while(i!=-1) { fos.write(i); i=is.read(); } */
					 
					System.out.println(id+"\t"+name+"\t"+file.getAbsolutePath());
					
					
				fos.close();
					
				}
				else {
					System.out.println("Result not found for ::" + id);
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally {
			Jdbc_Util.cleanUp(connection, ptmt, resultSet);
			scan.close();
		}
		
	}

}
