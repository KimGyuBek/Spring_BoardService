package com.basicproject.boardservice;

import com.basicproject.boardservice.data.entity.Member;
import com.basicproject.boardservice.data.entity.Posts;
import com.basicproject.boardservice.data.repository.MemberRepository;
import com.basicproject.boardservice.data.repository.PostsRepository;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitData {

    private final MemberRepository memberRepository;
    private final PostsRepository postsRepository;

    @PostConstruct
    private void initPosts() {
        Member member = Member.builder()
            .memberName("User1")
            .password("1234")
            .nickName("Member1")
            .build();

        Posts posts = Posts.builder()
            .title("title1")
            .contents("contents")
            .writer(member)
            .pageView(1)
            .build();

        memberRepository.save(member);
        postsRepository.save(posts);


    }

}
