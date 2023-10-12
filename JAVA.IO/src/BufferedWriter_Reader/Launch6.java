package BufferedWriter_Reader;

import java.io.*;

public class Launch6 {

	//Requirement => Write a program to remove duplicates from the file
	
	public static void main(String[] args) throws IOException {
		//FileWriter f= new FileWriter();
		PrintWriter p= new PrintWriter("phoneD.txt") ;
		
		BufferedReader b = new BufferedReader(new FileReader("imp.txt"));
		String target=b.readLine();
		boolean flag=true;

		while(target!=null) {
			BufferedReader b1 = new BufferedReader(new FileReader("phoneD.txt"));
			String line=b1.readLine();
			
			while(line!=null) {
				if(line.equals(target)) {
					flag=false;
					break;
				}
				line=b1.readLine();
			}
			if(flag==true)
				p.println(target);
			p.flush();
			
			target=b.readLine();
		}
		//p.flush();
		p.close();
		b.close();
		

	}

}
