package com.sjht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//启用定时任务（注解）
@EnableScheduling
public class SchoolFootballApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchoolFootballApplication.class,args);
        System.out.println("-------------------------------------------校园主球系统启动成功-------------------------------------------------");
    }
}
