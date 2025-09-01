package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    @Autowired
    @Lazy
    private BaseInitData self;
    private final PostService postService;


    @Bean
    ApplicationRunner initDataRunner(){
        return args -> {
            self.work1();
            self.work2();
//            new Thread(()->{
//                try {
//                    self.work3();
//                }catch (Exception ex){
//                    ex.printStackTrace();
//                }
//
//            }).start();
            self.work4();
        };
    }

    @Transactional
    void work1(){

        if(postService.getTotalCount()>0){
            return;
        }

        postService.write("제목1","내용1");
        postService.write("제목2","내용2");
    }

    @Transactional
    void work2(){

        Optional<Post> opPost = postService.getPost(1);
    }

    void work3() throws Exception{
        Post post1 = postService.getPost(1).get();
        Post post2 = postService.getPost(2).get();

        postService.delete(post1);

        if(true) throw new RuntimeException("테스트 예외 발생");

        postService.delete(post2);
    }

    @Transactional
    void work4(){
        Post post1 = postService.getPost(1).get();
        postService.modify(post1,"제목1-수정2","내용1-수정2");
    }

}
