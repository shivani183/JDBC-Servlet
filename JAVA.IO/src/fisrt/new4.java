package fisrt;
import java.io.*;
public class new4 {

	public static void main(String[] args) throws Exception{
//		String name="Shivani.txt";
//		File f= new File(name);
//		System.out.println(f.exists());
//		f.createNewFile();
//		System.out.println(f.exists());
		
		String Dirname="avi";
		File f1= new File(Dirname);
		System.out.println(f1.exists());
		f1.mkdir();
		System.out.println(f1.exists());

	}

}
