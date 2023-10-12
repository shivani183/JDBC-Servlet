package Listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {

	static {
		System.out.println("RequestAttributeListener.class file is loading...");
	}
	
	public RequestAttributeListener() {
		System.out.println("RequestAttributeListener obj file is created...");

	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println(srae.getName() + " ... attribute removed...");
	}

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println(srae.getName() + " ... attribute added...");
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println(srae.getName() + " ... attribute replaced...");
	}
	
}
