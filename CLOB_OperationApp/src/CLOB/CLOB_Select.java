package CLOB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.*;
import java.sql.Connection;

public class CLOB_Select {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection connection=null;
		PreparedStatement ptmt= null;
		ResultSet resultSet=null;
		Integer id=0;
		Scanner scan = null;
		
		try {
		connection=Jdbc_Util.jdbcSetConnection();
		     
			if(connection!=null) {
				String sqlSelectQuery="Select * from users where id=?";
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
					System.out.println("id\tname\tdoc");
					id=resultSet.getInt(1);
					String name=resultSet.getString(2);
					Reader read=resultSet.getCharacterStream(3);
					File file = new File("place.pdf");
					FileWriter fw= new FileWriter(file);
					IOUtils.copy(read, fw);

					System.out.println(id+"\t"+name+"\t"+file.getAbsolutePath());
					fw.close();
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
