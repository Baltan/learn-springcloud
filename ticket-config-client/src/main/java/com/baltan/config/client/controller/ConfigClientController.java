package com.baltan.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-02-25 22:54
 */
@RestController
public class ConfigClientController {

    @Value("${environment}")
    private String environment;

    @GetMapping("/getEnvironment")
    public String getEnvironment() {
        return "当前代码运行环境：" + environment;
    }
}
