package filters;


import domain.users.Customer;
import domain.users.Owner;
import domain.users.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by InteNs on 18.jun.2015.
 */
public class loggedinFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        if(request.getSession().getAttribute("current_user")== null)filterChain.doFilter(servletRequest,servletResponse);
        if(request.getSession().getAttribute("current_user") instanceof Customer) request.getRequestDispatcher("/secure/customer.jsp").forward(servletRequest,servletResponse);;
        if(request.getSession().getAttribute("current_user") instanceof Owner) request.getRequestDispatcher("/secure/admin.jsp").forward(servletRequest,servletResponse);
    }


    @Override
    public void destroy() {

    }
}
