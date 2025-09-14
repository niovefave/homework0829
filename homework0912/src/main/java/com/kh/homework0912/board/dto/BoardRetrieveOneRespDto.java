package com.kh.homework0912.board.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardRetrieveOneRespDto {

    private Long no;
    private String title;
    private String content;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
