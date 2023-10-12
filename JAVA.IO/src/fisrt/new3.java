package fisrt;

import java.io.*;

public class new3 {

	public static void main(String[] args) throws IOException {
		File f= new File("imp.txt");
		FileWriter fw= new FileWriter(f,true);
		fw.write("\n");
		fw.write(97);
		fw.write("\n");fw.write("\n");
		fw.write("shiv");
		fw.write("\n");fw.write("\n");
		char[] ch= {'h','e','y'};
		fw.write(ch);
		
		//to do action successfully
		fw.flush();
		fw.close();
		
		System.out.println("check there");

	}

}
