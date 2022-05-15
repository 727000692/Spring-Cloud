package com.zust.nie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author njy
 * @Date 2022/4/21 10:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Select9091 {
    public static void main(String[] args) {
        SpringApplication.run(Select9091.class,args);
    }
}
