package com.gabekim.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    

    @RequestMapping("/")
    public String index() {
        return "api";
    }
}
