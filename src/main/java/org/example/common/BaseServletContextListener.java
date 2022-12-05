package org.example.common;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

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
