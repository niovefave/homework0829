package com.kh.homework0912.board.api;

import com.kh.homework0912.board.dto.BoardInsertReqDto;
import com.kh.homework0912.board.dto.BoardModifyReqDto;
import com.kh.homework0912.board.dto.BoardRetrieveOneRespDto;
import com.kh.homework0912.board.dto.BoardRetrieveRespDto;
import com.kh.homework0912.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("insert")
    public void insertBoard(@RequestBody BoardInsertReqDto insertReqDto){
        boardService.insertBoard(insertReqDto);
    }

    @GetMapping
    public List<BoardRetrieveRespDto> retrieveBoardList(){
        return boardService.retrieveBoardList();
    }

    @GetMapping("{no}")
    public BoardRetrieveOneRespDto retrieveOne(@PathVariable Long no){
        return boardService.retrieveOne(no);
    }

    @PutMapping("{no}")
    public void modifyBoard(@RequestBody BoardModifyReqDto modifyReqDto, @PathVariable Long no){
        boardService.modifyBoard(modifyReqDto , no);
    }

    @DeleteMapping("{no}")
    public void deleteBoard(@PathVariable Long no){
        boardService.deleteBoard(no);
    }

    @GetMapping("/title")
    public Page<BoardRetrieveOneRespDto> selectByTitle(@RequestParam String title , Pageable pageable){
        return boardService.selectByTitle(title , pageable);
    }

    @GetMapping("/content")
    public Page<BoardRetrieveOneRespDto> selectByContent(@RequestParam String content , Pageable pageable){
        return boardService.selectByContent(content , pageable);
    }

    @GetMapping("/keyword")
    public Page<BoardRetrieveOneRespDto> selectByTitleAndContent(@RequestParam String keyword , Pageable pageable){
        return boardService.selectByTitleAndContent(keyword , pageable);
    }
}
