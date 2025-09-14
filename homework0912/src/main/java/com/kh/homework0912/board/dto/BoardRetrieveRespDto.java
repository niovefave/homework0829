package com.kh.homework0912.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardRetrieveRespDto {

    private Long no;
    private String title;
    private LocalDateTime createdAt;

}

