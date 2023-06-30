package com.example.membership.service.impl;

import com.example.membership.membership.model.Member;
import com.example.membership.membership.repositories.MemberEntityRepository;
import com.example.membership.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberEntityRepository memberEntityRepository;

    @Autowired
    public MemberServiceImpl(MemberEntityRepository memberEntityRepository) {
        this.memberEntityRepository = memberEntityRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Member> findAll() {
        return this.memberEntityRepository.findAll();
    }

    @Override
    public Member find(BigDecimal id) {
        Optional<Member> op = this.memberEntityRepository.findById(id);
        return op.orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public Member findById(BigDecimal id) {
        Optional<Member> op = this.memberEntityRepository.findById(id);
        return op.orElse(null);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void save(Member memberEntity) {
        if (Objects.isNull(memberEntity.getId())) {
            memberEntity.setCreateDate(Calendar.getInstance().getTime());
            memberEntity.setActive(true);
            this.memberEntityRepository.save(memberEntity);
        } else {
            throw new DuplicateKeyException(String.format("%s , id is exists", memberEntity));
        }

    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void deleteById(BigDecimal id) {
        Optional<Member> memberOptional = this.memberEntityRepository.findById(id);
        if(memberOptional.isEmpty()){
            throw new NullPointerException(String.format("%s is not exited",id.toPlainString()));
        }
        Member member = memberOptional.get();
        member.setActive(false);
        member.setStopDate(Calendar.getInstance().getTime());
        this.memberEntityRepository.save(member);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void update(Member memberEntity) {
        if (Objects.isNull(memberEntity.getId()) || Objects.isNull(this.findById(memberEntity.getId()))) {
            throw new NullPointerException(String.format("%s is not existed in table", memberEntity));
        } else {
            this.memberEntityRepository.save(memberEntity);
        }
    }
}
