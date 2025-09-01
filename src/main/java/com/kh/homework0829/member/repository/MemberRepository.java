package com.kh.homework0829.member.repository;

import com.kh.homework0829.member.dto.MemberDto;
import com.kh.homework0829.member.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void join(MemberEntity entity) {
        em.persist(entity);
    }

    public MemberEntity login(MemberDto dto) {
        String jpql = "select m from MemberEntity m where m.userId = :userId and m.userPwd = :userPwd and delYn = 'N'";
        return em.createQuery(jpql , MemberEntity.class)
                .setParameter("userId" , dto.getUserId())
                .setParameter("userPwd" , dto.getUserPwd())
                .getSingleResult();
    }

    public MemberEntity findByNo(Long writerNo) {
        return em.find(MemberEntity.class , writerNo);
    }
}
