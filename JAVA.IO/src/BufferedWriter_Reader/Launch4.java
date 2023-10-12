package BufferedWriter_Reader;
import java.io.*;
public class Launch4 {

	public static void main(String[] args) throws Exception {
		FileWriter f= new FileWriter("file.txt");
		PrintWriter p= new PrintWriter(f,true);
		
		BufferedReader br= new BufferedReader(new FileReader("santa.txt"));
		String myLine=br.readLine();
		while(myLine!=null) {
			p.println(myLine);
			myLine=br.readLine();
		}
		BufferedReader br1= new BufferedReader(new FileReader("trees.txt"));
		myLine=br1.readLine();
		while(myLine!=null) {
			p.println(myLine);
			myLine=br1.readLine();
		}
		p.flush();
		p.close();

	}

}
