package com.aqi.zuobiji.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("/")
    public String sayHello(){
        return "Hello zuobiji";
    }
}
