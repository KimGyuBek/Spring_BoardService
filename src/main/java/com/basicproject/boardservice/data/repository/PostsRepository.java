package com.basicproject.boardservice.data.repository;

import com.basicproject.boardservice.data.entity.Posts;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

//    Page<Posts> findByTitleContaining(String keyword, Pageable pageable);


}
