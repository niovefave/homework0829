package com.kh.homework0912.board.entity;

import com.kh.homework0912.board.dto.*;
import com.kh.homework0912.board.repository.BoardRepository;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String title;
    private String content;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BoardEntity() {
        createdAt = LocalDateTime.now();
        delYn = "N";
    }

    public static BoardEntity from(BoardInsertReqDto insertReqDto){
        BoardEntity entity = new BoardEntity();
        entity.title = insertReqDto.getTitle();
        entity.content = insertReqDto.getContent();
        return entity;
    }

    public static BoardRetrieveRespDto toDto(BoardEntity entity){
        BoardRetrieveRespDto retrieveRespDto = new BoardRetrieveRespDto();
        retrieveRespDto.setNo(entity.no);
        retrieveRespDto.setTitle(entity.title);
        retrieveRespDto.setCreatedAt(entity.createdAt);

        return retrieveRespDto;
    }

    public static BoardRetrieveOneRespDto toRetrieveOneDto(BoardEntity entity){
        BoardRetrieveOneRespDto retrieveOneRespDto = new BoardRetrieveOneRespDto();
        retrieveOneRespDto.setNo(entity.no);
        retrieveOneRespDto.setTitle(entity.title);
        retrieveOneRespDto.setContent(entity.content);
        retrieveOneRespDto.setDelYn(entity.delYn);
        retrieveOneRespDto.setCreatedAt(entity.createdAt);
        retrieveOneRespDto.setUpdatedAt(entity.updatedAt);
        return retrieveOneRespDto;
    }

    public void modify(BoardModifyReqDto modifyReqDto) {
        title = modifyReqDto.getTitle();
        content = modifyReqDto.getContent();
        updatedAt = LocalDateTime.now();
    }

    public void delete(Long no) {
        delYn = "Y";
        updatedAt = LocalDateTime.now();
    }
}
