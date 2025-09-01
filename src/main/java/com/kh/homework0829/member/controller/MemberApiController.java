package com.kh.homework0829.member.controller;

import com.kh.homework0829.member.dto.MemberDto;
import com.kh.homework0829.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("join")
    public void join(@RequestBody MemberDto dto){
        memberService.join(dto);
    }

    @PostMapping("login")
    public MemberDto login(@RequestBody MemberDto dto , HttpSession session){
        MemberDto loginMemberDto = memberService.login(dto);
        session.setAttribute("loginMemberDto" , loginMemberDto);
        return loginMemberDto;
    }

}
