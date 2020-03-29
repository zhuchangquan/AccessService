package com.example.utils;

import com.example.server.impl.GetRequestParser;
import com.example.server.impl.MultiPartBodyParser;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static GetRequestParser getGetParserInstance() {
        return getBean(GetRequestParser.class);
    }
    public static MultiPartBodyParser getMultiPartBodyParserInstance() {
        return getBean(MultiPartBodyParser.class);
    }
}
