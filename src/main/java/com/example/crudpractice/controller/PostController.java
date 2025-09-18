package com.example.crudpractice.controller;


import com.example.crudpractice.entity.Post;
import com.example.crudpractice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public String home() {
        return "post/index";
    }


    @GetMapping("/post/save")
    public String saveForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/createPostForm";
    }

    @PostMapping("/post/save")
    public String savePost(@ModelAttribute("post") Post post) {
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/posts")
    public String postList(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "post/postList";
    }

    @GetMapping("/posts/{id}")
    public String postDetail(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "post/postDetail";
    }

    @GetMapping("/post/{id}/update")
    public String updateForm(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "post/postUpdateForm";
    }

    @PostMapping("/posts/{id}")
    public String postUpdate(@PathVariable Long id, @ModelAttribute("post") Post post) {
        postService.update(post);
        return "redirect:/posts/" + id;
    }











}
