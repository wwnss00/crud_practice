package com.example.crudpractice.controller;


import com.example.crudpractice.entity.Post;
import com.example.crudpractice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public String home() {
        return "post/index";
    }


    @GetMapping("/posts/save")
    public String saveForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/createPostForm";
    }
}
