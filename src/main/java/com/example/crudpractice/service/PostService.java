package com.example.crudpractice.service;

import com.example.crudpractice.entity.Post;
import com.example.crudpractice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;


    public void save(Post post) {
        postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }




}
