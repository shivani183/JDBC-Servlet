package krishna.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


public class LogFilter implements Filter {
	private FilterConfig config;
       
	static {
		System.out.println("Log filter Loading..");
	}
    public LogFilter() {
		System.out.println("Log filter instantiation..");
    }

	public void destroy() {
		config=null;
		System.out.println("Log filter deinstantiation..");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(" log inside filter method");

		PrintWriter out = response.getWriter();
		out.println("Log processing- before processing");
		ServletContext context = config.getServletContext();
		HttpServletRequest req=(HttpServletRequest)request;
		context.log("A request is comming from : "+ request.getRemoteHost()+" for URL : "+req.getRequestURL()+" at "+ new Date());
		
		chain.doFilter(request, response);
		out.println("Log processing- after processing");	
	}

	public void init(FilterConfig config) throws ServletException {
		this.config=config;
		System.out.println("Log filter initialisation..");

	}

}
