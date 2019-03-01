package com.baltan.one.controller;

import com.baltan.one.feign.ZipkinOneFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-03-01 15:18
 */
@RestController
public class ZipkinOneController {

    @Autowired
    private ZipkinOneFeign zipkinOneFeign;

    @GetMapping("/sayHi")
    public String sayHi() {
        return zipkinOneFeign.sayHi();
    }

    @GetMapping("/responseHi")
    public String responseHi() {
        return "Hi!Nice to meet you!";
    }
}
