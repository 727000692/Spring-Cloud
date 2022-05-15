package com.zust.nie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author njy
 * @Date 2022/4/21 19:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Course8092 {
    public static void main(String[] args) {
        SpringApplication.run(Course8092.class,args);
    }
}