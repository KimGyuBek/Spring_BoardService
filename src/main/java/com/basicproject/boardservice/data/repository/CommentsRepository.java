package com.basicproject.boardservice.data.repository;

import com.basicproject.boardservice.data.entity.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    @Query("select c.comment, c.writer, c.createTime from Comments c where c.posts.id = :postsId")
    Page<Comments> findByWriterId(Pageable pageable, Long postsId);


}
