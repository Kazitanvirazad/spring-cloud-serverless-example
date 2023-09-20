package com.cloud.springbootserverless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.cloud.springbootserverless"})
public class SpringbootServerlessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServerlessApplication.class, args);
    }

}
