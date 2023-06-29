package com.example.membership.data.vo.member;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
public class MemberVo implements Serializable {

    private BigDecimal id;

    private String firstName;

    private String lastName;

    private char sex;

    private Date birth;

    private String tel;

    private String address;

    private String name;

    public void setName(String name) {
        this.name = this.firstName + this.lastName;
    }


}
