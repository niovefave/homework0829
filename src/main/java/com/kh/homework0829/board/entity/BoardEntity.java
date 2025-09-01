package com.kh.homework0829.board.entity;

import com.kh.homework0829.board.dto.BoardDto;
import com.kh.homework0829.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
@Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writerNo" , nullable = false)
    private MemberEntity writer;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BoardEntity() {
        createdAt = LocalDateTime.now();
        delYn = "N";
    }

    public static BoardEntity from(BoardDto dto , MemberEntity writer){
        BoardEntity entity = new BoardEntity();
        entity.title = dto.getTitle();
        entity.content = dto.getContent();
        entity.writer = writer;

        return entity;
    }


    public void update(BoardDto dto) {
        title = dto.getTitle();
        content = dto.getContent();
        updatedAt = LocalDateTime.now();
    }

    public void delete() {
        delYn = "Y";
        updatedAt = LocalDateTime.now();
    }
}
