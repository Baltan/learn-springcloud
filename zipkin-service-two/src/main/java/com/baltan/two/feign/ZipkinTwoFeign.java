package com.baltan.two.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-03-01 15:31
 */
@FeignClient(value = "zipkin-service-one")
public interface ZipkinTwoFeign {

    @RequestMapping(value = "/responseHi", method = RequestMethod.GET)
    String sayHi();
}
