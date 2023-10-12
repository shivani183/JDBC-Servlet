package pack1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Insert2 {

	public static void main(String[] args) throws ParseException {
		
		//taking input string date from user.
		
		Scanner  scan= new Scanner(System.in);
		System.out.println("ENTER THE DATE in dd-MM-yyyy format :: ");
		String input = scan.next();
		
		//coverting user input into java.util.Date-
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate=sdf.parse(input);
		
		//converting util date to sql.Date-
		
		long l=udate.getTime();
		java.sql.Date sdate= new java.sql.Date(l);
		
		System.out.println("user string date is : "+input);
		System.out.println("java.util.Date is : "+udate);
		System.out.println("java.sql.Date is : "+ sdate);
		
		//When user is using same format as java.sql.date then no conversion needed-
		//onlt valueOf() method-

		System.out.println("enter date in yyyy-MM-dd form-");
		String stndDate =scan.next();
		java.sql.Date stndSDate=java.sql.Date.valueOf(stndDate);
		System.out.println(stndSDate);
		System.out.println(stndDate);
	}

}
