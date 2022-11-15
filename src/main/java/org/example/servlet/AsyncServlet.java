package org.example.servlet;

import org.example.bean.AsyncBean;

import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 
 */
@WebServlet(urlPatterns = "/public/asyncServlet")
@ServletSecurity(@HttpConstraint(rolesAllowed = "architect"))
@DeclareRoles("architect")
public class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    TestIdentityStore testIdentityStore;

    @EJB
    private AsyncBean asyncBean;

    @Inject
    SecurityContext securityContext;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        testIdentityStore.getClass().getName();
//        AsyncContext asyncContext = request.startAsync();
//        asyncContext.setTimeout(5000);
//
//        asyncBean.doAsync(asyncContext);
        response.getWriter().write("servlet response" + securityContext.getCallerPrincipal());
        asyncBean.doAsync(response);
    }

}