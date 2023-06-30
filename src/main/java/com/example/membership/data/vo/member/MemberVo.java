package com.example.membership.data.vo.member;

import com.example.membership.enums.Sex;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class MemberVo {
    private BigDecimal id;
    private String firstName;
    private String lastName;
    private Sex sex;
    private Date birth;
    private String tel;
    private String address;
    private String email;
}
