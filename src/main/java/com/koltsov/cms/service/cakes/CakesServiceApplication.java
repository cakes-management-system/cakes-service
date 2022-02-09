package com.koltsov.cms.service.cakes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CakesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CakesServiceApplication.class, args);
    }

}
