package com.basicproject.boardservice;

import com.basicproject.boardservice.data.entity.Comments;
import com.basicproject.boardservice.data.entity.Member;
import com.basicproject.boardservice.data.entity.Posts;
import com.basicproject.boardservice.data.repository.CommentsRepository;
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
    private final CommentsRepository commentsRepository;

    @PostConstruct
    private void initPosts() {
        Member member = geenrateMember("User1", "1234", "Member1");
        Posts posts = generatePosts(member, "title1", "contents", 1);
        Posts posts2 = generatePosts(member, "title2", "contents2", 1);
        Comments comments = generateComments(member, posts, "comments1");

        memberRepository.save(member);
        postsRepository.save(posts);
        commentsRepository.save(comments);

        postsRepository.save(posts2);
    }

    private Comments generateComments(Member member, Posts posts, String comments1) {
        Comments comments = Comments.builder()
            .comment(comments1)
            .posts(posts)
            .writer(member)
            .build();
        return comments;
    }

    private Posts generatePosts(Member member, String title, String contents, int pageView) {
        Posts posts = Posts.builder()
            .title(title)
            .contents(contents)
            .writer(member)
            .pageView(pageView)
            .build();
        return posts;
    }

    private Member geenrateMember(String memberName, String password, String nickName) {
        Member member = Member.builder()
            .memberName(memberName)
            .password(password)
            .nickName(nickName)
            .build();
        return member;
    }

}
