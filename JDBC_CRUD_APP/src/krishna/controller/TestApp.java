package krishna.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import Krishna_Util.Jdbc_Util;
import Krishna_serviceFactory.StudentServiceFactory;
import krishna.dto.Student;
import krishna.service.IStudentservice;
import krishna.service.StudentServiceImpl;

public class TestApp {
	
	public static void main(String[] args) throws IOException {
		BufferedReader brr=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPADTE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("Enter your choice Press [1,2,3,4,5] :: " );
			String option =brr.readLine();
			switch(option) {
			case "1":insertOperation();
				break;
			case "2":selectOperation();
				break;
			case "3":updateOperation();
				break;
			case "4":deleteOperation();
				break;
			case "5":System.out.println("THANKYOU FOR USING");
				System.exit(0);
			default:System.out.println("Invalid option please try again.");
					break;
			}	
		}	
	}
		private static void deleteOperation() {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter student id");
		int id=scan.nextInt();
		IStudentservice studentService= StudentServiceFactory.getStudentService();
		String msg=studentService.deleteStudent(id);
		
		if(msg.equalsIgnoreCase("success")) 
			System.out.println("record deletion successfully");
		else if((msg.equalsIgnoreCase("not found")))
			System.out.println("record not found for given id "+id);
		else 
			System.out.println("record deletion failed");
		
		
	}
		
	private static void selectOperation() {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter student id");
		int id=scan.nextInt();
		IStudentservice studentService= StudentServiceFactory.getStudentService();
		Student std=studentService.searchStudent(id);
		if(std!=null) {
			System.out.println(std);
			System.out.println("ID\tNAME\tCITY\tAGE");
			System.out.println(std.getId()+"\t"+std.getName()+"\t"+std.getCity()+"\t"+std.getAge());
		}else
			System.out.println("Record not found for given id.");
		
	}
		
		private static void insertOperation() {
			Scanner scan=new Scanner(System.in);

			System.out.println("enter student name");
			String name=scan.next();
			
			System.out.println("enter student city");
			String city=scan.next();
			
			System.out.println("enter student age");
			Integer age=scan.nextInt();
	
			IStudentservice studentService= StudentServiceFactory.getStudentService();
			String msg=studentService.addStudent(name, city, age);
			if(msg.equalsIgnoreCase("success")) 
				System.out.println("record inserted successfully");
			else
				System.out.println("record insertion failed");
		
	}
		private static void updateOperation() throws IOException {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter student id which needs to be upadted");
			String id=br.readLine();
			
			IStudentservice studentService= StudentServiceFactory.getStudentService();
			Student std=studentService.searchStudent(Integer.parseInt(id));
			
			if(std!=null) {
				Student newStudent = new Student();

				System.out.println("Student id is :: " + std.getId());
				newStudent.setId(std.getId());
				
				System.out.println("Student oldName is : "+std.getName()+" Enter newName :");
				String newName= br.readLine();
				if(newName.equals("")|| newName=="") 
					newStudent.setName(std.getName());
				else
					newStudent.setName(newName);
				
				System.out.println("Student oldCity is : "+std.getCity()+" Enter newCity :");
				String newCity= br.readLine();
				if(newCity.equals("")|| newCity=="") 
					newStudent.setCity(std.getCity());
				else
					newStudent.setCity(newCity);
				
				System.out.println("Student oldAge is : "+std.getAge()+" Enter newAge :");
				String newAge= br.readLine();
				if(newAge.equals("")|| newAge=="") 
					newStudent.setAge(std.getAge());
				else
					newStudent.setAge(Integer.parseInt(newAge));
				
				System.out.println("new object is: "+ newStudent);
				
				String status=studentService.updateStudent(newStudent);
				if(status.equalsIgnoreCase("success")) 
					System.out.println("updation successful");
				
				else
					System.out.println("updation not successfull");
				
			
			}else
				System.out.println("Record not found for given id.");
			
				
		
	}

}




