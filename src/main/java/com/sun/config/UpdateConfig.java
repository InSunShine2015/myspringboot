package com.sun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 表配置数据更新配置
 */
@Configuration
public class UpdateConfig {

    @Bean(initMethod = "loadDataFromDb")
    public SmsApp getSmsApp(){
        return new SmsApp();
    }

//    @Bean(initMethod = "loadDataFromDb")
//    public SmsModule getSmsModule(){
//        return new SmsModule();
//    }
}