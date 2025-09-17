package com.example.crudpractice.controller;


import com.example.crudpractice.entity.Post;
import com.example.crudpractice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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


}
