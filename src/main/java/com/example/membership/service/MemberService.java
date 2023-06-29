package com.example.membership.service;

import com.example.membership.membership.model.Member;

import java.math.BigDecimal;
import java.util.List;

public interface MemberService {

    public List<Member> findAll();

    public Member findById(BigDecimal id);

    public void save(Member memberEntity);

    public void deleteById(BigDecimal id);

    public void update(Member memberEntity);
}
