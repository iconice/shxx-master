package com.sjht.school.football.controller.sys;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version V1.0
 * @date 2018年7月13日
 * @author superzheng
 */
@Controller
public class RenderController {

    /*工作台*/
    @GetMapping("/workdest")
    public String workdest(){
        return "index/workdest";
    }

}
