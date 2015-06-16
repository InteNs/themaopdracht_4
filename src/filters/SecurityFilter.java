package filters;

import com.sun.net.httpserver.*;
import domain.users.User;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
                                    /* Filter is being placed into service, do nothing. */
    }

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        User user = (User) req.getSession().getAttribute("current_user");
        System.out.println(user);
        if(user != null) System.out.println(req.getSession().getAttribute("current_user"));
        if(user != null) {
            System.out.println("JANEE");
            System.out.println(user.getUserType());
            if(user.getUserType() == User.userType.CUSTOMER){
                System.out.println("Customer detected");
                req.getRequestDispatcher("/secure/customer.jsp").forward(request, resp);
            }
            if(user.getUserType() == User.userType.OWNER){
                System.out.println("admin detected");
                req.getRequestDispatcher("/secure/admin.jsp").forward(request,resp);
                chain.doFilter(request,resp);
            }
        }
        else req.getRequestDispatcher("/index.jsp").forward(request,resp);
    }
    public void destroy() {
                                    /* Filter is being taken out of service, do nothing. */
    }
}