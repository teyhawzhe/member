package com.example.membership.data.vo.member;

import com.example.membership.enums.Sex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
public class UpdateRequestVo {

    @NotBlank
    private BigDecimal id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 20)
    private String lastName;

    private Sex sex;

    @NotNull
    private Date birth;

    @NotBlank
    private String tel;

    @NotBlank
    private String address;

}
