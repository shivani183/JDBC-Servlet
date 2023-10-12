package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class new1 {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		
		//Step1. Load and register the Driver
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			String url="jdbc:mysql://localhost:3306/school";
			String userName="root";
			String passWord="Shivani123";
			
			//Step2. Establish the Connection with database
			connection=DriverManager.getConnection(url,userName,passWord);
			System.out.println("connection made");
			System.out.println(connection.getClass().getName());
			
			String sqlSelectQuery="select * from student";
			
			//Step3. Create statement Object and send the query
			statement =connection.createStatement();
			System.out.println("implementation by-"+statement.getClass().getName());
			
			resultset=statement.executeQuery(sqlSelectQuery);
			System.out.println("implementation by-"+resultset.getClass().getName());
			System.out.println();
			// STEP:4 PROCESSING RESULTSET
			
			while(resultset.next()) {
				Integer id=resultset.getInt(1);
				String fname= resultset.getString(2);
				String lname= resultset.getString(3);
				String city= resultset.getString(4);
				Integer age= resultset.getInt(5);
				
				System.out.println(id+"\t"+fname+"\t"+lname+"\t"+city+"\t"+age);
			}
			
			
		}	
		catch(ClassNotFoundException e){
			e.printStackTrace();
			}
		catch(SQLException e){
			e.printStackTrace();
			}
		catch(Exception e){
			e.printStackTrace();
			}
		finally {
			if(connection!=null) {
				try {
		//STEP:5 CLOSING CONNECTION			
					connection.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

}
