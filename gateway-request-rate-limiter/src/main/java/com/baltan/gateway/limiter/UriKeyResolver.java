package com.baltan.gateway.limiter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Description: 根据uri进行限流
 *              Reference: https://blog.csdn.net/forezp/article/details/85081162
 *
 * @author Baltan
 * @date 2019-03-03 22:33
 */
public class UriKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getURI().getPath());
    }
}
