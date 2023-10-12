package pack1;

import java.util.Date;

public class Insert {
	public static void main(String[] args) {
		
		Date uDate = new Date();
		System.out.println(uDate);
		
		long t=uDate.getTime();
		java.sql.Date time=new java.sql.Date(t);
		System.out.println(time);
		System.out.println(t);

	}

}
