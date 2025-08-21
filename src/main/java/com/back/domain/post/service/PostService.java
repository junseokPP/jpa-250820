package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void write(String title, String content) {

        Post post = new Post(title,content);
        postRepository.save(post);
    }

    public Optional<Post> getPost(int i) {
        return postRepository.findById(i);
    }

    public long getTotalCount() {
        return postRepository.count();
    }
}
