package com.example.bluesblogs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bluesblogs.mapper")
public class BluesBlogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BluesBlogsApplication.class, args);
    }

}
