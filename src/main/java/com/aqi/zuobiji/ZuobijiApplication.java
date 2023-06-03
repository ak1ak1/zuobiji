package com.aqi.zuobiji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aqi.zuobiji.Mapper")
public class ZuobijiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuobijiApplication.class, args);
    }

}
