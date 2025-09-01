package com.kh.homework0829.member.service;

import com.kh.homework0829.member.dto.MemberDto;
import com.kh.homework0829.member.entity.MemberEntity;
import com.kh.homework0829.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(MemberDto dto) {
        MemberEntity entity = MemberEntity.from(dto);
        memberRepository.join(entity);
        return entity.getNo();
    }

    public MemberDto login(MemberDto dto) {
        MemberEntity entity = memberRepository.login(dto);
        MemberDto loginMemberDto =  MemberDto.from(entity);
        return loginMemberDto;
    }
}
