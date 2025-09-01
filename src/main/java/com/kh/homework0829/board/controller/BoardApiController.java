package com.kh.homework0829.board.controller;

import com.kh.homework0829.board.dto.BoardDto;
import com.kh.homework0829.board.service.BoardService;
import com.kh.homework0829.member.dto.MemberDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping
    public Long insertBoard(@RequestBody BoardDto dto , HttpSession session){
        MemberDto loginMemberDto = (MemberDto) session.getAttribute("loginMemberDto");
        dto.setWriterNo(loginMemberDto.getNo());
        return boardService.insertBoard(dto);
    }

    @GetMapping
    public List<BoardDto> selectBoard(){
        return boardService.selectBoard();
    }

    @GetMapping("{no}")
    public BoardDto selectBoardByNo(@PathVariable Long no){
        return boardService.selectBoardByNo(no);
    }

    @PutMapping
    public void updateBoard(@RequestBody BoardDto dto , HttpSession session) throws Exception {
        MemberDto loginMemberDto = (MemberDto) session.getAttribute("loginMemberDto");
        Long writerNo = loginMemberDto.getNo();
        boardService.updateBoard(dto , writerNo);
    }

    @DeleteMapping("{no}")
    private void deleteBoard(@PathVariable Long no , HttpSession session){
        MemberDto loginMemberDto = (MemberDto) session.getAttribute("loginMemberDto");
        Long writerNo = loginMemberDto.getNo();
        boardService.deleteBoard(no , writerNo);
    }


}
