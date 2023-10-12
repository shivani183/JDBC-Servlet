package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

import customizeResponse.myResponse;

public class ReverseFilter extends HttpFilter implements Filter {
  
	public void destroy() {

	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse hResp=(HttpServletResponse) response;
		myResponse myResp = new myResponse(hResp);
		chain.doFilter(request, myResp);
	
	}
	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
