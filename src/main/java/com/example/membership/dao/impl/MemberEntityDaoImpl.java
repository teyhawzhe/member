package com.example.membership.dao.impl;

import com.example.membership.dao.MemberEntityDao;
import com.example.membership.membership.model.Member;
import com.example.membership.membership.repositories.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class MemberEntityDaoImpl implements MemberEntityDao {

    private final MemberEntityRepository memberEntityRepository;

    @Autowired
    public MemberEntityDaoImpl(MemberEntityRepository memberEntityRepository) {
        this.memberEntityRepository = memberEntityRepository;
    }


    @Override
    public List<Member> findAll() {
        return this.memberEntityRepository.findAll();
    }

    @Override
    public Member findById(BigDecimal id) {
        Optional<Member> op = this.memberEntityRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public void save(Member memberEntity) {
        this.memberEntityRepository.save(memberEntity);
    }

    @Override
    public void deleteById(BigDecimal id) {
        this.memberEntityRepository.deleteById(id);
    }

    @Override
    public void update(Member memberEntity) {
        this.memberEntityRepository.save(memberEntity);
    }
}
