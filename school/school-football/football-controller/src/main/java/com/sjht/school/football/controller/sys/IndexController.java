package com.sjht.school.football.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Map map){
        return "index/index";
    }

}
