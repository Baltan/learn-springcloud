package com.baltan.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 *
 * @author Baltan
 * @FeignClient的value属性值为服务提供者的id
 * @RequestMapping的value属性值为要调用的服务提供者的接口的url
 * @date 2019-02-04 14:49
 */
@FeignClient(value = "ticket-provider", fallback = ConsumerFeignClientHystrix.class) // 服务提供者的id
public interface ConsumerFeignClient {

    @RequestMapping(value = "/getTicket", method = RequestMethod.GET)
    String getTicket();
}
