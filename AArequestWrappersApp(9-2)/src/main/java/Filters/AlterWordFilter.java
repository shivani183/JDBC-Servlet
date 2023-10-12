package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import CustomiseRequest.CustomisedRequest;


@WebFilter("/test")
public class AlterWordFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hReq= (HttpServletRequest) request;
		CustomisedRequest cReq= new CustomisedRequest(hReq);
		chain.doFilter(cReq, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
