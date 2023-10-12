package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;


public class DemoFilter extends HttpFilter implements Filter {
   
	static {
		System.out.println("in static block");
	}
	public DemoFilter() {
		System.out.println("filter constructor");
	}
	public void destroy() {
		System.out.println("destroying");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("inside filter method");
		PrintWriter out = response.getWriter();
		out.println("DEmo processing- before processing");
		chain.doFilter(request, response);
		out.println("DEmo processing- after processing");

	}

	public void init(FilterConfig fConfig) throws ServletException {
	System.out.println("inside init of filter");
	
	}

}
