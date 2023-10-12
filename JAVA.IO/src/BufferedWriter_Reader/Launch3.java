package BufferedWriter_Reader;
import java.io.*;
public class Launch3 {

	public static void main(String[] args) throws Exception {
		
		FileWriter f= new FileWriter("trees.txt");
		PrintWriter out = new PrintWriter(f);
		out.write(100);
		out.println(false);
		out.println('d');
		out.println(12.33);
		out.println("shivani");
		out.flush();
		out.close();
		
		FileReader f1=new FileReader("trees.txt");
		BufferedReader bf= new BufferedReader(f1);
		String sound=bf.readLine();
		while(sound!=null) {
			System.out.println(sound);
			sound=bf.readLine();
		}
		

	}

}
