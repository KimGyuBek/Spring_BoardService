package com.basicproject.boardservice.service.impl;

import com.basicproject.boardservice.data.dto.MemberDto;
import com.basicproject.boardservice.data.entity.Member;
import com.basicproject.boardservice.data.repository.MemberRepository;
import com.basicproject.boardservice.service.MemberService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*회원가입*/
    @Override
    public void joinMember(Member member) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member);

//        비밀번호 암호화
    }

    @Override
    public void loginMember(MemberDto.LoginRequest loginDto) {
        Member findMember = memberRepository.findByMemberName(loginDto.getMemberName())
            .orElseGet(null);

        if (findMember != null) {
            if (findMember.getPassword().equals(loginDto.getPassword())) {
                log.info("[memberService] login!");
                return;
            }

            log.info("[memberService] loginError");

            throw new UsernameNotFoundException("일치하는 회원이 없습니다.");

        }

        throw new IllegalStateException("일치하는 회원이 없습니다.");


    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Member> memberEntityWrapper = memberRepository.findByMemberName(userName);
        Member memberEntity = memberEntityWrapper.orElse(null);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

        log.info("[loadUserByName] userName = " + userName);

        return new User(memberEntity.getMemberName(), memberEntity.getPassword(), authorities);
    }


}
