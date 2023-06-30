package com.example.membership.service.impl;

import com.example.membership.dao.MemberEntityDao;
import com.example.membership.membership.model.Member;
import com.example.membership.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberEntityDao memberEntityDao;

    @Autowired
    public MemberServiceImpl(MemberEntityDao memberEntityDao) {
        this.memberEntityDao = memberEntityDao;

    }

    @Transactional(readOnly = true)
    @Override
    public List<Member> findAll() {
        return this.memberEntityDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Member findById(BigDecimal id) {
        return this.memberEntityDao.findById(id);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void save(Member memberEntity) {
        if (Objects.isNull(memberEntity.getId())) {
            memberEntity.setCreateDate(Calendar.getInstance().getTime());
            this.memberEntityDao.save(memberEntity);
        } else {
            throw new DuplicateKeyException(String.format("%s , id is exists", memberEntity.toString()));
        }

    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void deleteById(BigDecimal id) {
        this.memberEntityDao.deleteById(id);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void update(Member memberEntity) {
        if (Objects.isNull(memberEntity.getId()) || Objects.isNull(this.findById(memberEntity.getId()))) {
            throw new NullPointerException(String.format("%s is not existed in table", memberEntity.toString()));
        } else {
            this.memberEntityDao.save(memberEntity);
        }
    }
}
