package com.kh.homework0829.board.service;

import com.kh.homework0829.board.dto.BoardDto;
import com.kh.homework0829.board.entity.BoardEntity;
import com.kh.homework0829.board.exception.BoardException;
import com.kh.homework0829.board.repository.BoardRepository;
import com.kh.homework0829.member.entity.MemberEntity;
import com.kh.homework0829.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public Long insertBoard(BoardDto dto) {
        MemberEntity memberEntity = memberRepository.findByNo(dto.getWriterNo());
        BoardEntity boardEntity = BoardEntity.from(dto , memberEntity);
        boardRepository.insertBoard(boardEntity);
        return boardEntity.getNo();
    }

    public List<BoardDto> selectBoard() {
        List<BoardEntity> entityList = boardRepository.selectBoard();
        return entityList.stream().map(BoardDto::from).toList();
    }

    public BoardDto selectBoardByNo(Long no) {
        BoardEntity entity = boardRepository.selectBoardByNo(no);
        return BoardDto.from(entity);
    }

    public void updateBoard(BoardDto dto, Long loginMemberNo) throws Exception {
        BoardEntity entity = boardRepository.selectBoardByNo(dto.getNo());
        if (entity.getWriter().getNo() != loginMemberNo ){
            throw new BoardException("[BOARD-001 / Fail Update]");
        }
        entity.update(dto);
    }

    public void deleteBoard(Long no, Long loginMemberNo) {
        BoardEntity entity = boardRepository.selectBoardByNo(no);
        if (entity.getWriter().getNo() != loginMemberNo){
            throw new BoardException("[BOARD-002 / Fail Delete]");
        }
        entity.delete();
    }
}
