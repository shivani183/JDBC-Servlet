package krishna;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestDemoListener implements ServletRequestListener {

	public static int count=0;

	static {
		System.out.println("RequestDemoListener is loading");
	}
   
	public RequestDemoListener() {
		System.out.println("RequestDemoListener is instantiated");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("Request obj is destroyed at : "+ new java.util.Date());
		System.out.println("RequestDemoListener.requestDestroyed()");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	count++;
    	System.out.println("Request obj created at : "+ new java.util.Date());
    	System.out.println("Hit count of the application is " +count);
		System.out.println("RequestDemoListener.requestInitialized()");
    }
	
}
