package com.example.demo.controller;

import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/fetch")
    public String fetchAndSavePost() {
        postService.fetchAndSavePost();
        return "Post fetched and saved successfully!";
    }
}
