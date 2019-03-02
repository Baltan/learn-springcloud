package com.baltan.consumer.feign;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-03-02 13:05
 */
@Component
public class ConsumerFeignClientHystrix implements ConsumerFeignClient {
    @Override
    public String getTicket() {
        return "error!";
    }
}
