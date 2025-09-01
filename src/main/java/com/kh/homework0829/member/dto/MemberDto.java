package com.kh.homework0829.member.dto;

import com.kh.homework0829.member.entity.MemberEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {

    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static MemberDto from(MemberEntity entity){
        MemberDto dto = new MemberDto();
        dto.no = entity.getNo();
        dto.userId = entity.getUserId();
        dto.userPwd = entity.getUserPwd();
        dto.userNick = entity.getUserNick();
        dto.delYn = entity.getDelYn();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();

        return dto;
    }



}
