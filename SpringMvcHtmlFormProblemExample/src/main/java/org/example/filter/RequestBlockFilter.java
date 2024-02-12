package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestBlockFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String header = request.getHeader("x-block-this-request");
        if (header != null) {
            response.sendError(403, "Request is blocked.");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
    /*В проекте SpringMvcFilterInterceptorExample.
    Добавьте фильтры, которые блокируют запрос и ответ по
    наличию заголовков x-block-this-request и x-block-this-response
    соответственно. Эти фильтры будут проверять наличие
    соответствующих заголовков и, если заголовок присутствует,
    блокировать обработку запроса или модификацию ответа.*/