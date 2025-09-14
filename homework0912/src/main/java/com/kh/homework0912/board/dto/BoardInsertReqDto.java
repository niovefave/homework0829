package com.kh.homework0912.board.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardInsertReqDto {

    private String title;
    private String content;

}
