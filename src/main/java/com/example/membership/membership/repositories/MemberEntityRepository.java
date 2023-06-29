package com.example.membership.membership.repositories;

import com.example.membership.membership.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MemberEntityRepository extends JpaRepository<Member, BigDecimal> {

}
