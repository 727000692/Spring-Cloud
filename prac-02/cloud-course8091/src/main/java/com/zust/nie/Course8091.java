package com.zust.nie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author njy
 * @Date 2022/4/20 22:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Course8091 {
    public static void main(String[] args) {
        SpringApplication.run(Course8091.class,args);
    }
}
