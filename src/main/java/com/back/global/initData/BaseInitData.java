package com.back.global.initData;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Bean
    ApplicationRunner initDataRunner(){
        return args -> {
            System.out.println("초기 데이터를 로딩합니다.");
        };
    }

}
