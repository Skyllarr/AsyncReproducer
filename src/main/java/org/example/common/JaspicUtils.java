package org.example.common;

import jakarta.security.auth.message.config.AuthConfigFactory;
import jakarta.security.auth.message.module.ServerAuthModule;
import jakarta.servlet.ServletContext;

/**
 *
 * 
 */
public final class JaspicUtils {

    private JaspicUtils() {
    }

    /**
     * Registers the given SAM using the standard JASPIC {@link AuthConfigFactory} but using a small set of wrappers that just
     * pass the calls through to the SAM.
     * 
     * @param serverAuthModule
     */
    public static void registerSAM(ServletContext context, ServerAuthModule serverAuthModule) {
        AuthConfigFactory.getFactory().registerConfigProvider(new TestAuthConfigProvider(serverAuthModule), "HttpServlet",
            getAppContextID(context), "Test authentication config provider");
    }

    public static String getAppContextID(ServletContext context) {
        return context.getVirtualServerName() + " " + context.getContextPath();
    }

}
