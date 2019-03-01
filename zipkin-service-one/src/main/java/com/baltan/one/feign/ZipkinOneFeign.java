package com.baltan.one.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-03-01 15:20
 */
@FeignClient(value = "zipkin-service-two")
public interface ZipkinOneFeign {

    @RequestMapping(value = "/sayHi", method = RequestMethod.GET)
    String sayHi();
}
