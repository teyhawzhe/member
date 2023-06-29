package com.example.membership.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class MemberDto implements Serializable {

    private BigDecimal id;

    private String firstName;

    private String lastName;

    private char sex;

    private char sexName;

    private Date birth;

    private String tel;

    private String address;

    private String name;
}
