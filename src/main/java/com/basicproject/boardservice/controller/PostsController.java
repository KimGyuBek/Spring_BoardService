package com.basicproject.boardservice.controller;

import com.basicproject.boardservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/posts/")
public class PostsController {

    private final PostsService postsService;

    /**
     *
     */
    @GetMapping("/view/{postId}")
    public String postsView(@PathVariable(value = "postId") Long postId, Model model) {
        model.addAttribute("postsForm", postsService.findById(postId));

        return "posts/posts_view";
    }
}
