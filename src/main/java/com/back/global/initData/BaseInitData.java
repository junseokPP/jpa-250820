package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner initDataRunner(){
        return args -> {

            Post post = new Post("제목1","내용1");
            postRepository.save(post);

            postRepository.findById(1);

        };
    }

}
