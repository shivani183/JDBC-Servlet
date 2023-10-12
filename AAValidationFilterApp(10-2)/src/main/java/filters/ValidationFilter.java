package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class ValidationFilter implements Filter {


	public ValidationFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean flag = true;
		String eid_err_msg = "", ename_err_msg = "", eage_err_msg = "", email_err_msg = "", mobile_err_msg = "";
		
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		PrintWriter out = response.getWriter();

		if (eid == null || eid.equals("")) {
			eid_err_msg = "Employee id is required";
			flag = false;
		}else {
			if(!eid.startsWith("Krishna-")) {
				eid_err_msg ="Employee id starts with Krishna-";
				flag = false;
			}else
				flag=true;
		}
		
		if (ename == null || ename.equals("")) {
			ename_err_msg = "Employee name is required";
			flag = false;
		}else {
			if((ename.length()<=3)) {
				ename_err_msg ="Employee name should be more than 3 words";
				flag = false;
			}else
				flag=true;
		}
		
		if (eage == null || eage.equals("")) {
			eage_err_msg = "Employee age is required";
			flag = false;
		}else {
			if((Integer.parseInt(eage)<20)||Integer.parseInt(eage)>30) {
				eage_err_msg ="Employee age should be in between 20 to 30 only.";
				flag = false;
			}else
				flag=true;
		}
		
		if (email == null || email.equals("")) {
			email_err_msg = "Employee mail id is required";
			flag = false;
		}else {
			if(!email.endsWith("@Krishna.in")) {
				email_err_msg ="Employee  mail id should ends with @Krishna.in";
				flag = false;
			}else
				flag=true;
		}
		if (mobile == null || mobile.equals("")) {
			mobile_err_msg = "Employee mobile no. is required";
			flag = false;
		}else {
			if(!mobile.startsWith("91-")) {
				mobile_err_msg ="Employee mobile no. should starts with 91-";
				flag = false;
			}else
				flag=true;
		}
		if (flag == true)
			chain.doFilter(request, response);
		else {
			out.println("<html><head><title>Output</title></head>");
			out.println("<body bgcolor='pink'>");
			out.println("<center>");
			out.println("<h1 style='color: Blue; text-align: center;'>KRISHNA COMPANY..</h1>");
			out.println("<h1 style='color:red'> Employee Registration Details</h1>");
			out.println("<form method='post' action='./reg'>");
			out.println("<table>");
			out.println("<tr><th>EID</th><td><input type='text' name='eid' value='" + eid + "'/></td><td><font color='red' size='5'>" + eid_err_msg
					+ "</font></td></tr>");
			out.println("<tr><th>ENAME</th><td><input type='text' name='ename' value='" + ename + "'/></td><td><font color='red' size='5'>" + ename_err_msg
					+ "</font></td></tr>");
			out.println("<tr><th>EAGE</th><td><input type='text' name='eage' value='" + eage + "'/></td><td><font color='red' size='5'>" + eage_err_msg
					+ "</font></td></tr>");
			out.println("<tr><th>EMAIL</th><td><input type='text' name='email' value='" + email + "'/></td><td><font color='red' size='5'>" + email_err_msg
					+ "</font></td></tr>");
			out.println("<tr><th>MOBILE</th><td><input type='text' name='mobile' value='" + mobile + "'/></td><td><font color='red' size='5'>" + mobile_err_msg
					+ "</font></td></tr>");
			out.println("<tr><td></td><td><input type='submit' value='reg'/></td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
