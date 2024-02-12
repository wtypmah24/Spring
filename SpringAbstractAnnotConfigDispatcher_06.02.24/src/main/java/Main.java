public class Main {
    public static void main(String[] args) {
    }
}
/*Шаги перехода:
Создать класс-инициализатор. Например, MyWebAppInitializer, расширяющий
AbstractAnnotationConfigDispatcherServletInitializer;
Создать класс конфигурации контекста Spring (@Configuration), внедрить в него ApplicationContext, перенести бины.
Для настройки Spring MVC класс конфигурации должен имплементировать интерфейс WebMvcConfigurer.
Переопределить нужные методы. Для замены стандартного ViewResolver – метод  configureViewResolvers.

Переопределить методы в MyWebAppInitializer:
getRootConfigClasses  - если требуется задать базовую конфигурацию Spring, указываем её класс.
В противном случае возвращаем null;
getServletConfigClasses – указываем класс конфигурации сервлета;
getServletMappings – сопоставляем обрабатываемые пути из URL нашему DispatcherServlet;
Можно удалить xml-файлы;*/