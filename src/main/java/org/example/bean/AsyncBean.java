package org.example.bean;

import org.example.servlet.TestIdentityStore;
//import org.jboss.ejb3.annotation.SecurityDomain;
//import org.jboss.ejb3.annotation.SecurityDomain;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Asynchronous;
import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

import org.wildfly.security.auth.server.SecurityDomain;
import org.wildfly.security.auth.server.SecurityIdentity;


/**
 * 
 *
 *
 */
@Stateless
public class AsyncBean {

    @Inject
    SecurityContext securityContext;

    @Asynchronous
    public void doAsync(AsyncContext asyncContext) {

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            interrupted();
        }

        try {
            asyncContext.getResponse().getWriter().write("async EJB caller principal is:  " + securityContext.getCallerPrincipal());
        } catch (IOException e) {
            e.printStackTrace();
        }

        asyncContext.complete();
    }
}
