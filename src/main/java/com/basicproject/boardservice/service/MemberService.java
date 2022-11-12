package com.basicproject.boardservice.service;

import com.basicproject.boardservice.data.dto.MemberDto;
import com.basicproject.boardservice.data.entity.Member;
import com.basicproject.boardservice.data.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface MemberService extends UserDetailsService {

    /*회원가입*/
    void joinMember(Member member);

    /*로그인*/
    void loginMember(MemberDto.LoginRequest loginDto);






}
