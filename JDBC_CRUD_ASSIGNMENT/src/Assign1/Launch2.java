package Assign1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


class Fact{
	Fact(){
		System.out.println("Press 1 for Insert operation");
		System.out.println("Press 2 for select operation");
		System.out.println("Press 3 for Update operation");
		System.out.println("Press 4 for Delete operation");
		System.out.print("Press 5 for exit     ");

	}
}
public class Launch2 {	
	Launch2() {
		System.out.println("          ***************************************************");
		System.out.println("                 WELCOME TO CONSOLE BASE APPLICATION");
		System.out.println("          ***************************************************");
		System.out.println();
	}
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement ptmt=null;
		PreparedStatement ptmt1=null;
		PreparedStatement ptmt2=null;
		PreparedStatement ptmt3=null;
		Launch2 launch = new Launch2();
		Fact fact= null;
		Scanner scan=null;	
		Integer input=0;
		Integer id=0;
		try {
			connection = Launch1.setConnection();
		
				while(1==1) {
					
					fact=new Fact();
					scan=new Scanner(System.in);
					input= scan.nextInt();
					if (input==1){
						String sqlInsertQuery="insert into student(name,city,age)"
							+ "values(?,?,?)";
					if(connection!=null)
						ptmt=connection.prepareStatement(sqlInsertQuery);
					if(ptmt!=null)
						{
							System.out.println("Enter Name of Student to Insert ::");
							String name= scan.next();
							
							System.out.println("Enter city to Insert ::");
							String city= scan.next();
							
							System.out.println("Enter Age to Insert::");
							Integer age= scan.nextInt();
				
							try {
								ptmt.setString(1, name);
								ptmt.setString(2, city);
								ptmt.setInt(3, age);
								int row=ptmt.executeUpdate();
								if(row==1) {
									System.out.println("Record Insertion Successfull.");
									System.out.println();
									continue;}
								else 
									System.out.println("Record Insertion Failed.");	
							}catch(SQLException e) {
								System.out.println("Record Insertion Failed.");
								System.out.println();
								continue;
							}
							catch(Exception e) {
								System.out.println("Record Insertion Failed.");
								System.out.println();
								continue;
							}
						}	
		}
					if(input==2) {
						if(connection!=null) {
							String sqlSelectQuery="Select * from student where id=?";
							ptmt1 = connection.prepareStatement(sqlSelectQuery);
						}
						
						if(ptmt1!=null) {
							System.out.println("Please Enter Student id..");
							id=scan.nextInt();
							ptmt1.setInt(1, id);
							resultSet=ptmt1.executeQuery();
						}
						if(resultSet!=null) {
							if(resultSet.next()) {
								System.out.println("id\tname\tcity\tage");
								System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
								resultSet.getString(3)+"\t"+resultSet.getInt(4));
								System.out.println();
								continue;
							}
							else {
								System.out.println("Result not found for ::" + id);
								System.out.println();
								continue;
							}
						}
					}
					if(input==3) {
						String sqlUpdate="Update student set name=? where id=?";
						
						if(connection!=null) {
							ptmt2=connection.prepareStatement(sqlUpdate);
						}
						if(ptmt2!=null) {
							scan=new Scanner(System.in);
							System.out.println("Enter id:: ");
							id=scan.nextInt();	
							System.out.println("Enter new Name--");
							String name=scan.next();
							try {
								ptmt2.setInt(2, id);
								ptmt2.setString(1, name);
								int smart=ptmt2.executeUpdate();
								if(smart==1) {
									System.out.println("Record Updated Succesfully with "+smart+" change");
									System.out.println();
									continue;}
								else {
									System.out.println("Record not available for given id");
									System.out.println();
									continue;}
							}catch(SQLException e) {
								//e.printStackTrace();
								System.out.println("Record Updation Failed");
								System.out.println();
								continue;
							}
						}
					}
					if(input==4) {
						String sqlDeleteQuery = "delete from student where id = ?";
						if (connection != null) {
							ptmt3 = connection.prepareStatement(sqlDeleteQuery);
						}
						if (ptmt3 != null) {
								scan = new Scanner(System.in);
								System.out.print("Enter the id of the student :: ");
								id= scan.nextInt();
								try {
									ptmt3.setInt(1, id);
									int rowCount = ptmt3.executeUpdate();
									if(rowCount==1) {
										System.out.println(rowCount + " Record deleted Successfully" );
										System.out.println();
										continue;}
									else {
										System.out.println("Record not available for given id");
										System.out.println();
										continue;}
								}catch(SQLException e) {
									System.out.println("Something Went Wrong TRY AGAIN");
									System.out.println();
									continue;
								}
								
							}
					}
					if(input==5) {
						System.out.println("  THANKYOU ");
						System.out.println("Have a Nice Day..");
						System.exit(0);
					}
					else{
						System.out.println("Invalid Operation try again");
						System.out.println();
						continue;
					}
				}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			Launch1.CleanUp(connection, ptmt, null);
			ptmt1.close();
			ptmt2.close();
			ptmt3.close();
			scan.close();
			
		}
	}

	

}
