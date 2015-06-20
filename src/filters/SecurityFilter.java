package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SecurityFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
                                    /* Filter is being placed into service, do nothing. */
    }

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        if (req.getSession().getAttribute("current_user") == null)req.getRequestDispatcher("/index.jsp").forward(request,resp);
        else chain.doFilter(request,resp);
    }
    public void destroy() {
                                    /* Filter is being taken out of service, do nothing. */
    }
}