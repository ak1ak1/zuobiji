package com.aqi.zuobiji.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration   // 暂时废弃，跨域由前端完成
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //允许跨域访问的路径
                .allowedOriginPatterns("http://localhost:8081/")   //允许跨域访问的源
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE")  //允许请求方法
                .maxAge(168000)     //预检间隔时间
                .allowedHeaders("*")    //允许头部设置
                .allowCredentials(true); //是否发送cookie
    }
}
