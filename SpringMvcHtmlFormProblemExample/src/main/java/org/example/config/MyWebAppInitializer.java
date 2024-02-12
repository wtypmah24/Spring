package org.example.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.example.filter.RequestBlockFilter;
import org.example.filter.RequestLogger;
import org.example.filter.ResponseBlockFilter;
import org.example.filter.ResponseLogger;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // Переопределяем метод, который запускается при старте web-приложения
    @Override
    public void onStartup(ServletContext myServletContext) throws ServletException {
        super.onStartup(myServletContext);
        registerHiddenFieldFilter(myServletContext); // добавляем в сервлет нужный фильтр
        registerRequestBlockFieldFilter(myServletContext);
        registerResponseBlockFilter(myServletContext);
        registerRequestLogger(myServletContext);
        registerResponseLogger(myServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext myServletContext) {
        myServletContext.addFilter(
                "hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter() // такой фильтр уже есть в Spring, поэтому его не нужно писать нам
        ).addMappingForUrlPatterns(
                null, // показывает, для каких случаев используется фильтр. null == REQUEST
                true, // добавить последним в цепочку ранее объявленных фильтров
                "/*" // показывает, на каких url будет срабатывать фильтр (на всех)
        );
    }

    private void registerRequestBlockFieldFilter(ServletContext myServletContext) {
        myServletContext.addFilter(
                "requestBlockFilter",
                new RequestBlockFilter()
        ).addMappingForUrlPatterns(
                null,
                true,
                "/*"
        );
    }

    private void registerResponseBlockFilter(ServletContext myServletContext) {
        myServletContext.addFilter("responseBlockFilter", new ResponseBlockFilter())
                .addMappingForUrlPatterns(null, true, "/*");
    }
    private void registerRequestLogger(ServletContext myServletContext){
        myServletContext.addFilter("requestLogger", new RequestLogger())
                .addMappingForUrlPatterns(null, true, "/*");
    }
    private void registerResponseLogger(ServletContext myServletContext){
        myServletContext.addFilter("responseLogger", new ResponseLogger())
                .addMappingForUrlPatterns(null, true, "/*");
    }
}