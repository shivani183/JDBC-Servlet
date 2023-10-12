package krishna.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class DemoFilter implements Filter {
	static {
	  System.out.println("Demo filter.class is loading");
		}
    public DemoFilter() {
  	  System.out.println("Demo filter.class is instantiated");
    }

	public void destroy() {
		  System.out.println("Demo filter.class is deinstantiated");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("DEmo processing- after processing");	
		chain.doFilter(request, response);
		out.println("DEmo processing- after processing");	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		  System.out.println("Demo filter.class is initialised");
	}

}
