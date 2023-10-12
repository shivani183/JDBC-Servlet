package CustomiseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomisedResponse extends HttpServletResponseWrapper {

	public CustomisedResponse(HttpServletResponse response) {
		super(response);
	}

	

}
