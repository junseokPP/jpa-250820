package com.back.global.initData;

import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
@Profile("test")
public class TestInitData {

    private final PostService postService;


    @Bean
    ApplicationRunner testInitDataRunner(){
        return args -> {

            postService.write("테스트용 제목1","테스트용 내용1");
            postService.write("테스트용 제목2","테스트용 내용2");

            System.out.println("테스트 전용 데이터 생성 완료.");
        };
    }
}
