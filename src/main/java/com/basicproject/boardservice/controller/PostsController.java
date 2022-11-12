package com.basicproject.boardservice.controller;

import com.basicproject.boardservice.data.entity.Comments;
import com.basicproject.boardservice.service.CommentsService;
import com.basicproject.boardservice.service.PostsService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/posts/")
@Slf4j
public class PostsController {

    private final PostsService postsService;
    private final CommentsService commentsService;

    @GetMapping("/view/{postId}")
    public String postsView(@PathVariable(value = "postId") Long postsId, Model model,
        Pageable pageable) {
        model.addAttribute("postsForm", postsService.findById(postsId));
        model.addAttribute("commentsList", commentsService.findByPostId(pageable, postsId));
        postsService.updateView(postsId);

//        Page<Comments> byPostId = commentsService.findByPostId(pageable, postsId);
//        List<Comments> comments = byPostId.toList();
//        for (Comments comment : comments) {
//            log.info("[postController] comment={}", comment);
//        }

        return "posts/posts_view";
    }
}
