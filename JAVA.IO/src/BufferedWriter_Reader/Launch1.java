package BufferedWriter_Reader;
import java.io.*;
public class Launch1 {

	public static void main(String[] args) throws Exception {
		FileWriter fw= new FileWriter("santa.txt");
		BufferedWriter bw= new BufferedWriter(fw);
		bw.write(105);
		bw.write('N');
		bw.write("ueron");
		bw.newLine();
		char[] ch= {'s','h','i','v','a'};
		bw.write(ch);
		
		bw.flush();
		bw.close();
		

	}

}
