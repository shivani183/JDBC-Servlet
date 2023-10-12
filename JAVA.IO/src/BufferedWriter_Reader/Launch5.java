package BufferedWriter_Reader;
import java.io.*;
public class Launch5 {

	//1. Requirement => file1.txt ,file2.txt copy all the contents to file3.txt
	
	//2. Requirement => file1.txt file2.txt copy one line from file1.txt and 
	//                  from file2.txt to file3.txt.
			          
	
	public static void main(String[] args) throws Exception{
		FileWriter f= new FileWriter("One2one.txt");
		PrintWriter p = new PrintWriter(f);
		
		BufferedReader b1= new BufferedReader(new FileReader("santa.txt"));
		String s1=b1.readLine();
		//p.println(s1);
		
		BufferedReader b2= new BufferedReader(new FileReader("trees.txt"));
		String s2=b2.readLine();
//		p.println(s2);
//		
//		b.close();
//		b1.close();
		
		while(s1!=null || s2!=null) {
			if(s1!=null) {
				p.println(s1);
				s1=b1.readLine();
			}
			if(s2!=null) {
				p.println(s2);
				s2=b2.readLine();
			}	
		}
		p.flush();
		b1.close();
		b2.close();

	}

}
