package com.example.springangularfinalproject.controllers;

import com.example.springangularfinalproject.entities.Post;
import com.example.springangularfinalproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/list")
    public ModelAndView getAllPosts() {
        ModelAndView mav = new ModelAndView("list-posts");
        mav.addObject("posts", postRepository.findAll());
        return mav;
    }

    @GetMapping("/addPostForm")
    public ModelAndView addPostForm() {
        ModelAndView mav = new ModelAndView("add-post-form");
        Post newPost = new Post();
        mav.addObject("post", newPost);
        return mav;
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long postId) {
        ModelAndView mav = new ModelAndView("add-post-form");
        Post post = postRepository.findById(postId).get();
        mav.addObject("post", post);
        return mav;
    }

    @GetMapping("/deletePost")
    public String deletePost(@RequestParam Long postId) {
        postRepository.deleteById(postId);
        return "redirect:/list";
    }


}
