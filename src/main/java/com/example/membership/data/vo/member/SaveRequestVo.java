package com.example.membership.data.vo.member;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class SaveRequestVo {

    @NotNull
    @Size(min = 1, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 20)
    private String lastName;

    @Size(min = 1, max = 1)
    private char sex;

    @NotNull
    private Date birth;

    @NotNull
    private String tel;

    @NotNull
    private String address;


}
