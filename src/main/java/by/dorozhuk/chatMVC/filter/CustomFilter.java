package by.dorozhuk.chatMVC.filter;

import by.dorozhuk.chatMVC.constant.Role;
import by.dorozhuk.chatMVC.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) servletRequest;
        User currentUser = (User) request1.getSession().getAttribute("currentUser");
        if (currentUser != null && currentUser.getRole().equals(Role.USER)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else throw new ServletException();
    }

    @Override
    public void destroy() {

    }
}
