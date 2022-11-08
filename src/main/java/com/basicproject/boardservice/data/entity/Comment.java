package com.basicproject.boardservice.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Comment extends BaseTime{

    @Id
    @GeneratedValue
    @Column(name = "commentsid")
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String comment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Posts posts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

}
