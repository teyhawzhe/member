package com.example.membership.membership.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity(name = "MEMBER")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "MEMBER_SEQ")
    @SequenceGenerator(sequenceName = "MEMBER_SEQ",allocationSize = 1,name = "MEMBER_SEQ")
    @Column(nullable = false)
    private BigDecimal id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private char sex;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birth;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createDate;

    @ToString.Exclude
    @Column(nullable = false)
    private boolean isActive;

}


