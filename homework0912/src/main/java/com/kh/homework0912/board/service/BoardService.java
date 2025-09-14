package com.kh.homework0912.board.service;

import com.kh.homework0912.board.dto.BoardInsertReqDto;
import com.kh.homework0912.board.dto.BoardModifyReqDto;
import com.kh.homework0912.board.dto.BoardRetrieveOneRespDto;
import com.kh.homework0912.board.dto.BoardRetrieveRespDto;
import com.kh.homework0912.board.entity.BoardEntity;
import com.kh.homework0912.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void insertBoard(BoardInsertReqDto insertReqDto) {
        BoardEntity entity = BoardEntity.from(insertReqDto);
        boardRepository.save(entity);
    }

    public List<BoardRetrieveRespDto> retrieveBoardList() {
       List<BoardEntity> boardList = boardRepository.findByDelYn("N");
       return boardList.stream().map(BoardEntity::toDto).toList();
    }

    public BoardRetrieveOneRespDto retrieveOne(Long no) {
        BoardEntity entity = boardRepository.findById(no).get();
        return BoardEntity.toRetrieveOneDto(entity);
    }

    public void modifyBoard(BoardModifyReqDto modifyReqDto, Long no) {
        BoardEntity entity = boardRepository.findByNo(no);
        entity.modify(modifyReqDto);
        boardRepository.save(entity);
    }

    public void deleteBoard(Long no) {
        BoardEntity entity = boardRepository.findByNo(no);
        entity.delete(no);
        boardRepository.save(entity);
    }


    public Page<BoardRetrieveOneRespDto> selectByTitle(String title, Pageable pageable) {
       return boardRepository.findByTitleContaining(title , pageable)
               .map(BoardEntity::toRetrieveOneDto);
    }

    public Page<BoardRetrieveOneRespDto> selectByContent(String content, Pageable pageable) {
        return boardRepository.selectByContent(content , pageable)
                .map(BoardEntity::toRetrieveOneDto);
    }

    public Page<BoardRetrieveOneRespDto> selectByTitleAndContent(String keyword, Pageable pageable) {
        return boardRepository.selectByTitleAndContent(keyword , pageable)
                .map(BoardEntity::toRetrieveOneDto);
    }
}
