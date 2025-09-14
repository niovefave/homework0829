package com.kh.homework0912.board.repository;


import com.kh.homework0912.board.dto.BoardRetrieveOneRespDto;
import com.kh.homework0912.board.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findByDelYn(String n);

    BoardEntity findByNo(Long no);

//  이건 그냥 delYn 관계없이 다나와버림
    Page<BoardEntity> findByTitleContaining(String title, Pageable pageable);

//  그래서 쿼리문 적어버리기
    @Query("select b from BoardEntity b where b.delYn = 'N' And b.content LIKE %:content%")
    Page<BoardEntity> selectByContent(String content, Pageable pageable);

//  AND 랑 OR 같이쓰면 ()로 구분하라는데 없어도 잘되긴함.. 
    @Query("select b from BoardEntity b where b.delYn = 'N' And (b.title LIKE %:keyword% OR b.content LIKE %:keyword%)")
    Page<BoardEntity> selectByTitleAndContent(String keyword, Pageable pageable);

}
