package com.fb.pqBlg.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fb.pqBlog.eneity")
public class ManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class);
    }
}
