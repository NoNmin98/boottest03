package com.lzy.boottest03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@MapperScan("com.lzy.boottest03")
@SpringBootApplication
public class Boottest03Application {

    public static void main(String[] args) {
        SpringApplication.run(Boottest03Application.class, args);
    }

}
