package com.ray.chapter315.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Ray
 * @date 2018/7/1 0001
 */
@RestController
public class HelloController {

    @ApiIgnore
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(){
        return "Hello World";
    }
}
