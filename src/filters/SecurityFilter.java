package filters;

import domain.User;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
                                    /* Filter is being placed into service, do nothing. */
    }

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;

        if(req.getSession().getAttribute("current_user") != null) {
            User user = (User)req.getSession().getAttribute(("current_user"));
            if(user.getUserType() == User.userType.CUSTOMER){
                System.out.println("Customer detected");
                req.getRequestDispatcher("/secure/welcome.jsp").forward(request,resp);
            }
            if(user.getUserType() == User.userType.OWNER){
                System.out.println("admin detected");
                req.getRequestDispatcher("/secure/admin.jsp").forward(request,resp);
            }
        }
        else req.getRequestDispatcher("/index.jsp").forward(request,resp);
    }
    public void destroy() {
                                    /* Filter is being taken out of service, do nothing. */
    }
}