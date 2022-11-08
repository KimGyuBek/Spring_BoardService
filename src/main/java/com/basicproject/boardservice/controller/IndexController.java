package com.basicproject.boardservice.controller;

import com.basicproject.boardservice.service.PostsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class IndexController {

    private final PostsService postsService;

    /*home*/
    @GetMapping("/")
    public String home(Model model, Pageable pageable) {
        model.addAttribute("postsList", postsService.findAll(pageable));

        log.info("[indexController] home loading");
        return "index";
    }


}
