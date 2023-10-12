package fisrt;
import java.io.File;
public class new6 {
	public static void main(String[] args) {
		String location="/Users/avinashsingh/Desktop";	
		File f= new File(location);
		String[] names=f.list();
		int Tcount=0;
		int Pcount=0;
		int count=0;
		int filecount=0;
		int dircount=0;
		for(String name:names) {
			  if(name.endsWith(".txt")) { 
				  System.out.println(name); 
				  Tcount++; }
			  if(name.endsWith(".jpg")) { 
				  System.out.println(name); 
				  Pcount++; } 
			  else {
			  count++; 
			  System.out.println(name); }
			  }
		System.out.println(Pcount); 
		System.out.println(Tcount);
	    System.out.println(count);
		  
		for(String name:names) {
			File f1=new File(f,name);
			if(f1.isDirectory()) {
				System.out.println(name);
				dircount++;
			}
			if(f1.isFile()) {
				System.out.println(name);
				filecount++;
			}
		}
		
		System.out.println(filecount);
		System.out.println(dircount);
		
		  
		 
	}
}
