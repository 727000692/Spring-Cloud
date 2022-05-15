package com.example.prac01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {

    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com"))//扫描指定的包
                .build()
                .groupName("111");
    }
    //配置swagger信息：apiInfo
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("niejunyu","www.baidu","111@qq.com");

        return new ApiInfo(
                "测试的swaggerApi文档",
                "测试的描述",
                "v1.0",
                "www.baidu.com",
                contact,
                "apache2.0",
                "www.baidu.com",
                new ArrayList<>()
        );
    }


}
