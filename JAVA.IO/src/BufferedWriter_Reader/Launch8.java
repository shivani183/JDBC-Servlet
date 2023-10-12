package BufferedWriter_Reader;
import java.io.*;
public class Launch8 {

	//Requirement- Write a code to read the data from the file and identify which 
	//              data is of larger in length(assuming the data is String)
	
	public static void main(String[] args) throws Exception {
		BufferedReader f= new BufferedReader(new FileReader("imp.txt"));
		String name=f.readLine();		
		int maxlength=0;
		String result = "";
		while(name!=null) {
			int datalength=name.length();
			
			if(maxlength<datalength) {
				maxlength=datalength;
				result=name;
				}
			
			name=f.readLine();
			
		}
		
		System.out.println(maxlength);
		System.out.println(result);
		

	}

}
