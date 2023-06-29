package com.example.membership.dao;

import com.example.membership.membership.model.Member;

import java.math.BigDecimal;
import java.util.List;

public interface MemberEntityDao {

    public List<Member> findAll();

    public Member findById(BigDecimal id);

    public void save(Member memberEntity);

    public void deleteById(BigDecimal id);

    public void update(Member memberEntity);

}
