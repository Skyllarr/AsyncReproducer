package org.example.bean;

import org.example.servlet.TestIdentityStore;
//import org.jboss.ejb3.annotation.SecurityDomain;
//import org.jboss.ejb3.annotation.SecurityDomain;

import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Asynchronous;
import jakarta.ejb.EJBContext;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

//    @Resource
//    EJBContext ejbCotext;

    @Asynchronous
    public void doAsync(AsyncContext asyncContext) {

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            interrupted();
        }

        try {
//            asyncContext.getResponse().getWriter().write(ejbCotext.getCallerPrincipal().getName() + "async EJB security context caller principal is:  " + securityContext.getCallerPrincipal() + "        AND     ");
            asyncContext.getResponse().getWriter().write("async injected security context caller principal is:  " + securityContext.getCallerPrincipal().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        asyncContext.complete();
    }

    public void doSync(HttpServletResponse response) {

        try {
//            response.getWriter().write("Sync EJB caller principal is:  " + securityContext.getCallerPrincipal() + "        AND     ");
            response.getWriter().write("Sync EJB caller principal is:  " + "        AND     ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
