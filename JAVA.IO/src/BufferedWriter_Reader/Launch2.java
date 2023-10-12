package BufferedWriter_Reader;
import java.io.*;
public class Launch2 {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("santa.txt");
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		while(line!=null) {
			System.out.println(line);
			line=br.readLine();
		}
		br.close();
					

	}

}
