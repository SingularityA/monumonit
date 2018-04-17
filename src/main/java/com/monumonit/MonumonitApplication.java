package com.monumonit;

import com.monumonit.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MonumonitApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
