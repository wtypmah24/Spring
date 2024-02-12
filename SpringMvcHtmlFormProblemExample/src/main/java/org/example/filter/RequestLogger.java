package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

public class RequestLogger implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURL().toString();
        System.out.println("Request URL: " + url);

        System.out.println("Requested params: ");
        request.getParameterMap().forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));

        System.out.println("Requested Headers: ");
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()){
            String headerName = headers.nextElement();
            System.out.println(headerName + ": " + request.getHeaders(headerName));
        }

        //TODO: log request body.


        filterChain.doFilter(request, response);
    }
}
