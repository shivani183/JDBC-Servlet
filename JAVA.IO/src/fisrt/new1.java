package fisrt;

import java.io.File;
import java.io.IOException;

public class new1 {

	public static void main(String[] args) throws IOException {
		String location="c.\\pws";
		File f= new File(location);
		f.mkdir();
		System.out.println(f.isDirectory());

//		File f1= new File(f,"abi.txt");
//		f1.createNewFile();
//		System.out.println(f1.isFile());
	}

}
