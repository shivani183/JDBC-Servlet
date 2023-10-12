package fisrt;

import java.io.File;

public class new2 {

	public static void main(String[] args) {
		String location = "/Users/avinashsingh";
		int filecount=0;
		int dircount=0;
		
		File f= new File(location);
		String[] names=f.list();
		for( String n:names) {
			File f1= new File(f,n);
			if(f1.isDirectory()) {
				dircount++;
			}
			if(f1.isFile()) {
				if(n.endsWith(".pdf"))
				filecount++;
			}
		
			System.out.println(n);
		}
		System.out.println(dircount);
		System.out.println(filecount);
		

		
	}

}
