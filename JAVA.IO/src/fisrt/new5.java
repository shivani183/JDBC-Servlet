package fisrt;

import java.io.File;
import java.io.IOException;

public class new5 {

	public static void main(String[] args) throws IOException {
		String comp="inueron";
		File f= new File(comp);
		f.mkdir();
		System.out.println(f.exists());
		File f1= new File(f,"mainfile.txt");
		f1.createNewFile();
		System.out.println(f1.exists());
		
		String location="/Users/avinashsingh/Desktop.\\hello";
		File f2= new File(location);
		f2.mkdir();
		System.out.println(f2.exists());

	}

}
