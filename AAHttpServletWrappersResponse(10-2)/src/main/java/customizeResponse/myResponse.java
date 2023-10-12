package customizeResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import writer.myWriter;

public class myResponse extends HttpServletResponseWrapper{

	public myResponse(HttpServletResponse response) {
		super(response);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		
		PrintWriter out = super.getWriter();
		myWriter mywriter = new myWriter(out);
		return mywriter;
	}

}
