package Listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class requestAttributeListener implements ServletRequestAttributeListener {

	static {
		System.out.println("requestAttributeListener.class file is loaded");
	}
	public requestAttributeListener() {
		System.out.println("requestAttributeListener obj is created");
	}

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 

    	System.out.println(srae.getName()+" Attributes removed"); 
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println(srae.getName()+" Attributes added"); 
    
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println(srae.getName()+" Attributes replaced"); 

    }
	
}
