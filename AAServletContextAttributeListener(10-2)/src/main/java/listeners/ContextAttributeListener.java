package listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextAttributeListener implements ServletContextAttributeListener {

	static {
		System.out.println("ContextAttributeListener.class file is loading...");
	}
    public ContextAttributeListener() {
		System.out.println("ContextAttributeListener obj file is created...");
    }

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
		System.out.println(scae.getName() + " ... attribute added...");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println(scae.getName() + " ... attribute removed...");
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	System.out.println(scae.getName() + " ... attribute replaced...");
    }
	
}
