package com.zust.nie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author njy
 * @Date 2022/4/21 22:34
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Select9092 {
    public static void main(String[] args) {
        SpringApplication.run(Select9092.class,args);
    }
}
