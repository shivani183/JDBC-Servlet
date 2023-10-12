package CustomiseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomisedRequest extends HttpServletRequestWrapper {

	public CustomisedRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {

		System.out.println("Customised Request.getParameter()");
		
		System.out.println("Name is : "+ name);
		
		String word = super.getParameter(name);
		
		System.out.println("Name is : "+ word);

		
		if(word.equalsIgnoreCase("java")|| word.equalsIgnoreCase("jee")|| word.equalsIgnoreCase("spring"))
			return "SLEEP";
		return word;
	}

}
