package org.example.servlet;

import org.example.bean.AsyncBean;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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