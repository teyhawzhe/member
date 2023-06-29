package com.example.membership.data.vo.member;

import java.math.BigDecimal;
import java.util.Date;

public record MemberVoR(BigDecimal id,String firstName,String lastName,char sex,Date birth,String tel,String address) {
}
