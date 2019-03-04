package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("applicationÏú»Ù");
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
         System.out.println("application´´½¨");
    }
	
}
