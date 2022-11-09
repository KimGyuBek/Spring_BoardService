package com.basicproject.boardservice.service.impl;

import com.basicproject.boardservice.data.entity.Posts;
import com.basicproject.boardservice.data.repository.PostsRepository;
import com.basicproject.boardservice.service.PostsService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;

    @Override
    public Page<Posts> findAll(Pageable pageable) {
        return postsRepository.findAll(pageable);
    }

    @Override
    public Posts findById(Long postsId) {
//        postsRepository.findById(postId).orElseThrow(() -> new IllegalException("error"))
        return postsRepository.findById(postsId).get();
    }

    /*pageView update*/
    @Override
    public int updateView(Long postsId) {
        return postsRepository.updateView(postsId);
    }
}
