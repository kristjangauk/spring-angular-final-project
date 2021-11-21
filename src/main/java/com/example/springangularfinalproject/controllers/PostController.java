package com.example.springangularfinalproject.controllers;

import com.example.springangularfinalproject.entities.Post;
import com.example.springangularfinalproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@ResponseBody
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @PostMapping("/post")
    public Post createTodo(@Validated @RequestBody Post post) {
        Post createdPost = new Post();
        createdPost.setPost(post.getPost());
        createdPost.setUserId(post.getUserId());
        return postRepository.save(post);
    }
}
