package com.kh.homework0829.member.entity;

import com.kh.homework0829.board.entity.BoardEntity;
import com.kh.homework0829.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@Getter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false , unique = true)
    private String userId;
    @Column(nullable = false)
    private String userPwd;

    private String userNick;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String delYn;

    public MemberEntity() {
        createdAt = LocalDateTime.now();
        delYn = "N";
    }

    public static MemberEntity from(MemberDto dto){
        MemberEntity entity = new MemberEntity();
        entity.userId = dto.getUserId();
        entity.userPwd = dto.getUserPwd();
        entity.userNick = dto.getUserNick();

        return entity;
    }


}
