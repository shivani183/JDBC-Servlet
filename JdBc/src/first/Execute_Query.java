package first;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class Execute_Query {

	public static void main(String[] args) throws SQLException {
		
		//Step1. Load and register the Driver
		
			//Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			String url="jdbc:mysql:///school";
			String userName="root";
			String passWord="Shivani123";
			
			//Step2. Establish the Connection with database
			Connection connection=DriverManager.getConnection(url,userName,passWord);
			System.out.println("connection made");
			System.out.println(connection.getClass().getName());
			
			String sqlSelectQuery="select * from student";
			
			//Step3. Create statement Object and send the query
			Statement statement =connection.createStatement();
			System.out.println("implementation by-"+statement.getClass().getName());
			
			ResultSet resultset=statement.executeQuery(sqlSelectQuery);
			System.out.println("implementation by-"+resultset.getClass().getName());
			System.out.println();
			// STEP:4 PROCESSING RESULTSET
			
			while(resultset.next()) {
				Integer id=resultset.getInt("id");
				String fname= resultset.getString("fname");
				String lname= resultset.getString("lname");
				String city= resultset.getString("city");
				Integer age= resultset.getInt("age");
				
				System.out.println(id+"\t"+fname+"\t"+lname+"\t"+city+"\t"+age);
			}
			resultset.close();
			statement.close();
			connection.close();	
		}
	}
	

