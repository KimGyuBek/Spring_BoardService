package com.basicproject.boardservice.service.impl;

import com.basicproject.boardservice.data.entity.Comments;
import com.basicproject.boardservice.data.repository.CommentsRepository;
import com.basicproject.boardservice.service.CommentsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    @Override
    public Page<Comments> findAll(Pageable pageable) {
        return commentsRepository.findAll(pageable);
    }

    @Override
    public Page<Comments> findByPostId(Pageable pageable, Long postsId) {
        return commentsRepository.findByWriterId(pageable, postsId);
    }

    @Override
    public int uploadComments(Comments comments) {
        return 0;
    }
}
