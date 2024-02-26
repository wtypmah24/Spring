package org.example.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.logging.Logger;
@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("Hello from: " + request.getLocalAddr());
        chain.doFilter(request, response);
    }
}
