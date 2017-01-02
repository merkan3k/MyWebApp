package com.merkan.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vova on 02.01.2017.
 */
@WebFilter()
public class ExceptionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        System.out.println(httpResponse.getStatus());
        if (httpResponse.getStatus() == 200) {
            httpResponse.sendRedirect("/error.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
