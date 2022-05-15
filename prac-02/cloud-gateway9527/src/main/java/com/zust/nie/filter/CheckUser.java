package com.zust.nie.filter;

import com.zust.nie.entities.Power;
import com.zust.nie.mapper.PowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @Author njy
 * @Date 2022/4/21 19:33
 */
@Component
public class CheckUser implements GlobalFilter, Ordered {

    @Autowired
    private PowerMapper powerMapper;

    @Value("/user")
    private String path;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //获取请求
        String requestPath = exchange.getRequest().getPath().toString().substring(0,5);
        if (requestPath.equals(path)){
            return chain.filter(exchange);
        }
        String token = exchange.getRequest().getQueryParams().getFirst("token");

        byte[] bytes = ("你还没有登录，没有权限访问此请求:"+exchange.getRequest().getPath()+",请登录！").getBytes(StandardCharsets.UTF_8);
        DataBuffer wrap = exchange.getResponse().bufferFactory().wrap(bytes);
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        if (token == null){
            return exchange.getResponse().writeWith(Flux.just(wrap));
        }
        Power power = powerMapper.checkToken(token);
        if (power == null){
            return exchange.getResponse().writeWith(Flux.just(wrap));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
