package com.zust.nie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author njy
 * @Date 2022/4/20 23:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Arrange9081 {
    public static void main(String[] args) {
        SpringApplication.run(Arrange9081.class,args);
    }
}
