package com.zust.nie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author njy
 * @Date 2022/4/21 22:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class User8082 {
    public static void main(String[] args) {
        SpringApplication.run(User8082.class,args);
    }
}
