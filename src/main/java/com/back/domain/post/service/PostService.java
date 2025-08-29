package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void write(String title, String content) {

        Post post = new Post(title,content);
        postRepository.save(post);
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);

        boolean isChanged = false;

        if(!post.getTitle().equals(title)){
            post.setTitle(title);
            isChanged = true;
        }

        if(!post.getContent().equals(content)){
            post.setContent(content);
            isChanged = true;
        }

        if(isChanged){
            post.setModifyDate(LocalDateTime.now());
        }

        postRepository.save(post);
    }

    public Optional<Post> getPost(int i) {
        return postRepository.findById(i);
    }

    public long getTotalCount() {
        return postRepository.count();
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }
}
