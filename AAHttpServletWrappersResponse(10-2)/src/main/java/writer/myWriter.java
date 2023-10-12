package writer;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class myWriter extends PrintWriter{

	@Override
	public void println(String data) {

		System.out.println("myWriter is called");
		if(!data.startsWith("<")) {
			StringBuffer sb= new StringBuffer(data);
			out.println(sb.reverse());
		}else {
			out.println(data);
		}
	}
	
	PrintWriter out;
	public myWriter(PrintWriter out) throws FileNotFoundException{
		super(out);
		this.out=out;
	}

}
