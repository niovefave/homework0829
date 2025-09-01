package com.kh.homework0829.board.dto;

import com.kh.homework0829.board.entity.BoardEntity;
import com.kh.homework0829.member.dto.MemberDto;
import com.kh.homework0829.member.entity.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDto {

    private Long no;
    private String title;
    private String content;
    private Long writerNo;
    private String writerNick;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BoardDto from(BoardEntity entity){
        BoardDto dto =  new BoardDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        dto.writerNo = entity.getWriter().getNo();
        dto.writerNick = entity.getWriter().getUserNick();
        dto.delYn = entity.getDelYn();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();

        return dto;
    }

}
