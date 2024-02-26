package org.example.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.example.filter.LogFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{PersistenceConfig.class}; // добавили конфигурацию
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // Переопределяем метод, который запускается при старте web-приллжения
    @Override
    public void onStartup(ServletContext myServletContext) throws ServletException {
        super.onStartup(myServletContext);
        registerHiddenFieldFilter(myServletContext);
        registerLogFilter(myServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext myServletContext) {
        myServletContext.addFilter(
                "hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()
        ).addMappingForUrlPatterns(null, true, "/*");
    }
        private void registerLogFilter(ServletContext myServletContext) {
            myServletContext.addFilter(
                    "logFilter",
                    new LogFilter()
            ).addMappingForUrlPatterns(null, true, "/*");
    }
}
