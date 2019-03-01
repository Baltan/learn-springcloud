package com.baltan.two.controller;

import com.baltan.two.feign.ZipkinTwoFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-03-01 15:30
 */
@RestController
public class ZipkinTwoController {

    @Autowired
    private ZipkinTwoFeign zipkinTwoFeign;

    @GetMapping("/sayHi")
    public String sayHi() {
        return zipkinTwoFeign.sayHi();
    }

}
