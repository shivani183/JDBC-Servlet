package BufferedWriter_Reader;
import java.io.*;
public class Launch7 {

	//Requirement => Write a program to perform extraction of mobile no 
	//                only if there is no duplicates
	
	public static void main(String[] args) throws Exception{
		PrintWriter p= new PrintWriter("output.txt");
		BufferedReader f= new BufferedReader(new FileReader("phoneD.txt"));
		String match=f.readLine();
		boolean flag=true;
		while(match!=null) {
			BufferedReader f1= new BufferedReader(new FileReader("imp.txt"));
			String with=f1.readLine();
			
			while(with!=null) {
				if(with.equals(match)) {
					flag=false;
					break;
				}
				with=f1.readLine();	
			}
			if(flag==true) {
				p.println(match);
				p.flush();
			}
			match=f.readLine();
		}
		p.close();
		f.close();
		

	}

}
