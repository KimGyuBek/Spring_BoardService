package com.basicproject.boardservice.data.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Member extends BaseTime {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String memberName;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickName;


    @OneToMany(mappedBy = "writer")
    private List<Posts> postList = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    private List<Comment> commentList = new ArrayList<>();

}
