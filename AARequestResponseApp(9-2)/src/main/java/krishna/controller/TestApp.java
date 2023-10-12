package krishna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter	out=response.getWriter();
	LocalDateTime date=LocalDateTime.now();
	String msg="";
	int hour=date.getHour();
	if(hour<12)
		msg+="Good Morning";
		
	else if(hour<16)
		msg+="Good Afternoon";
	else if(hour<20)
		msg+="Good Evening";
	else
		msg+="Good Night";
	out.println("<html>");
	out.println("<body>");
	out.println("<center>");
	out.println("<h1>WELCOME TO SERVLET CODING</h1>");
	out.println("<h1 style'color:blue;text-align:center;'>Current Date and Time is "+date+"</h1>");
	out.println("<h1 style'color:olive;text-align:center;'>Greetings "+msg+"</h1>");
	out.println("<br>Request obj address"+ request.hashCode()+"</br>");
	out.println("<br>Response obj address"+ response.hashCode()+"</br>");
	out.println("<br>Current Servlet obj address"+ this.hashCode()+"</br>");
	out.println("<br>Current request Thread-obj address"+ Thread.currentThread().hashCode()+"</br>");

	out.println("</center>");
	out.println("</body>");
	out.println("</html>");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	out.close();
	
	}

}
