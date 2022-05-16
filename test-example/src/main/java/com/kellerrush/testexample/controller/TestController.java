package com.kellerrush.testexample.controller;

import com.kellerrush.cloud.cnacos.MyTemplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "OK";
    }
}
