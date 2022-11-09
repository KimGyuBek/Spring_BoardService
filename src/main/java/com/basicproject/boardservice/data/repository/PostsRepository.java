package com.basicproject.boardservice.data.repository;

import com.basicproject.boardservice.data.entity.Posts;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long> {

//    Page<Posts> findByTitleContaining(String keyword, Pageable pageable);

    /*pageView update*/
    @Modifying
    @Query("update Posts p set p.pageView = p.pageView + 1 where p.id = :postsId")
    int updateView(Long postsId);

}
