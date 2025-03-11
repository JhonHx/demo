package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzhiqiang
 * @date 2025/3/10
 * @apiNote
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "hello world " + System.currentTimeMillis() ;
    }

}
