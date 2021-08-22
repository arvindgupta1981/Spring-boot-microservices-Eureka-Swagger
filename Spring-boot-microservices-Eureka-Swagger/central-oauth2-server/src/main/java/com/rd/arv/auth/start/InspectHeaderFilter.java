package com.rd.arv.auth.start;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class InspectHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {


        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("++++++++++++++++++++++++=I AM HITTING THE AUTH SERVER: " + httpServletRequest.getHeader("Authorization"));
        Enumeration<String> enu = httpServletRequest.getHeaderNames();
        while(enu.hasMoreElements()) {
        	String header = enu.nextElement();
        	System.out.println(header + "++++++++++++++++++++++++=I AM HITTING THE AUTH SERVER: Header " + httpServletRequest.getHeader(header));
        	
        }
        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}