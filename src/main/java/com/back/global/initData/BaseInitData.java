package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class BaseInitData {

    @Autowired
    public PostService postService;

    @Bean
    ApplicationRunner initDataRunner(){
        return args -> {
            work1();
            work2();
        };
    }

    void work1(){

        if(postService.getTotalCount()>0){
            return;
        }

        postService.write("제목1","내용1");
        postService.write("제목2","내용2");
    }

    void work2(){

        Optional<Post> opPost = postService.getPost(1);
    }

}
