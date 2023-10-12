package Jdbc_Standard;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Useing_jdbc_util {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
	
		try {
			connection=Jdbc_Util.jdbcSetConnection();
			
			if(connection!=null) {
				statement=connection.createStatement();
			}
			if(statement!=null) {
				String mySql="select * from student";
				resultSet=statement.executeQuery(mySql);
			}
			if(resultSet!=null) {
				System.out.println("id\tfname\tlname\tcity\tage");
				while(resultSet.next()) {
//					System.out.printf("%d%s%s%s%d",resultSet.getInt(1),resultSet.getString(2),
//							resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5));
				
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+
								resultSet.getString(4)+"\t"+resultSet.getInt(5));
				}
			}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			Jdbc_Util.cleanUp(connection, statement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
}
