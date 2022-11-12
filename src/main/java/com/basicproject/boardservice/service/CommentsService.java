package com.basicproject.boardservice.service;

import com.basicproject.boardservice.data.entity.Comments;
import com.basicproject.boardservice.data.repository.CommentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CommentsService {

    Page<Comments> findAll(Pageable pageable);

    Page<Comments> findByPostId(Pageable pageable, Long postsId);

    int uploadComments(Comments comments);




}
