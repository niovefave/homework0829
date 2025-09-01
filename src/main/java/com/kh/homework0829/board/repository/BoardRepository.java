package com.kh.homework0829.board.repository;

import com.kh.homework0829.board.entity.BoardEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void insertBoard(BoardEntity boardEntity) {
        em.persist(boardEntity);
    }

    public List<BoardEntity> selectBoard() {
        String jpql = "select b from BoardEntity b where b.delYn = 'N' order by b.no desc";
        return em.createQuery(jpql , BoardEntity.class).getResultList();
    }

    public BoardEntity selectBoardByNo(Long no) {
        return em.find(BoardEntity.class , no);
    }
}
