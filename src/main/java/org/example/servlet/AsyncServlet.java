package org.example.servlet;

import org.example.bean.AsyncBean;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 
 */
@WebServlet(urlPatterns = "/public/asyncServlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private AsyncBean asyncBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(5000);
        asyncBean.doAsync(asyncContext);
    }

}