package io.app.kafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class ApplicationContextHolder {

    @Autowired
    ApplicationContext applicationContext;

    private static ApplicationContextHolder _instance;

    @PostConstruct
    public void initialize() {
        _instance = this;
    }

    public static Object getBean(String beanName) {
        return _instance.applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        return _instance.applicationContext.getBean(clazz);
    }
}
