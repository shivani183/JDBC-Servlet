package fisrt;
import java.io.*;

public class new8 {

	public static void main(String[] args) throws Exception {
		File f= new File("newfile.txt");
		FileReader f1= new FileReader(f);
		
		//it will read one char and store in array
		char[] ch=new char[(int)f.length()];
		f1.read(ch);
		for(char data:ch) {
			System.out.print(data);
		}
		f1.close();
	}
}
