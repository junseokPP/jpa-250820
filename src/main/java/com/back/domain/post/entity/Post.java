package com.back.domain.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private final String title;

    @Column(columnDefinition = "TEXT")
    private final String content;

    public Post(){
        this.title = "";
        this.content = "";
    }

}
