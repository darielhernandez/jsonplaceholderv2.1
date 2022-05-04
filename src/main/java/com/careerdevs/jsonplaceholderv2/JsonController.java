package com.careerdevs.jsonplaceholderv2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/json")
public class JsonController {

    @GetMapping("/test")
    public String test(){
        return "Test worked!";
    }
}