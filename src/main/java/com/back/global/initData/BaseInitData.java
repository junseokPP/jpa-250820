package com.back.global.initData;

import com.back.domain.member.entity.Member;
import com.back.domain.member.service.MemberService;
import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
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
    @Autowired
    private MemberService memberService;


    @Bean
    ApplicationRunner initDataRunner(){
        return args -> {
            self.work1();
        };
    }

    @Transactional
    void work1(){

        if(postService.getTotalCount()>0){
            return;
        }

        Member member1 = new Member("systemUser", "시스템");
        Member member2 = new Member("adminUser", "관리자");
        Member member3 = new Member("user1", "유저1");
        Member member4 = new Member("user2", "유저2");
        Member member5 = new Member("user3", "유저3");

        memberService.join("systemUser","시스템");
        memberService.join("adminUser","관리자");
        memberService.join("user1","유저1");
        memberService.join("user2","유저2");
        memberService.join("user3","유저3");


        postService.write("제목1","내용1");
        postService.write("제목2","내용2");
    }

    @Transactional
    void work2(){

        Optional<Post> opPost = postService.getPost(1);
    }


}
