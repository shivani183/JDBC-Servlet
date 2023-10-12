package fisrt;

import java.io.*;
public class new7 {

	public static void main(String[] args) throws Exception {
		
		//read()
		//read(char[])
		
//		FileReader fr= new FileReader("imp.txt");
//		int i=fr.read();
//		while(i!=(-1)) {
//		    System.out.println((char)i+"====>"+i);
//		    
//		    // to enter in next line
//		    i=fr.read();
//		}
		
		File f= new File("newfile.txt");
		f.createNewFile();
		System.out.println(f.exists());
		
		FileWriter f1= new FileWriter(f,true);
		f1.write("Hyder");
		
		
		f1.flush();
		f1.close();
		
		
		

	}

}
