package org.example.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 *
 */
public class BaseServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // NOOP
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // NOOP
    }

}
