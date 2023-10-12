package krishna;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextListener implements ServletContextListener {

	public static int count=0;
	static {
		System.out.println("ContextListener.class is loading");
	}
	
    public ContextListener() {
		System.out.println("ContextListener obj is created..");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("RequestContextListener.requestdestroyed()");
    	System.out.println("Request obj destroyed at : "+ new java.util.Date());
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	count++;
    	System.out.println("Request obj created at : "+ new java.util.Date());
    	System.out.println("Hit count of the application is " +count);
		System.out.println("RequestContextListener.requestInitialized()");
    }
	
}
