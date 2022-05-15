package com.zust.nie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author njy
 * @Date 2022/4/18 14:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class User8081 {
    public static void main(String[] args) {
        SpringApplication.run(User8081.class,args);
    }
}
