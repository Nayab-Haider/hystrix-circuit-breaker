package com.nayab.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class OrdermanagementappApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdermanagementappApplication.class, args);
    }

}
