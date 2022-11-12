package com.basicproject.boardservice.controller;

import com.basicproject.boardservice.data.dto.MemberDto;
import com.basicproject.boardservice.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    /**
     * spring security test
     *
     */

    @GetMapping("/login/test")
    public String loginTest() {
        return "testForm";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "loginSuccess";
    }

    /**
     * 로그인
     */
    /*loginForm*/
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginDto") MemberDto.Request loginDto) {

        return "member/login_Form";
    }

//    @PostMapping("/login")
//    public String loginProc() {
//        return "redirect:/";
//    }

//    @PostMapping("/login")
//    public String loginProc(@ModelAttribute("loginDto") MemberDto.LoginRequest loginDto) {
//        memberService.loginMember(loginDto);
//
//        return "redirect:/";
//
//    }


    /**
     * 회원가입
     */
    /*joinForm*/
    @GetMapping("/join")
    public String joinForm(@ModelAttribute("joinDto") MemberDto.Request joinDto) {
        return "member/join_Form";
    }

    /*joinProc*/
    @PostMapping("/join")
    public String joinProc(MemberDto.Request joinDto) {
        memberService.joinMember(joinDto.toEntity());
        log.info("[join]");

        return "redirect:/";
    }

}



