package com.basicproject.boardservice.service;

import com.basicproject.boardservice.data.entity.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PostsService {

    Page<Posts> findAll(Pageable pageable);

    Posts findById(Long postId);


}
