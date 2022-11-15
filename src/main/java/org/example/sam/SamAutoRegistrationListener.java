package org.example.sam;

import org.example.common.BaseServletContextListener;
import org.example.common.JaspicUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 *
 * 
 */
@WebListener
public class SamAutoRegistrationListener extends BaseServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JaspicUtils.registerSAM(sce.getServletContext(), new TestServerAuthModule());
    }

}