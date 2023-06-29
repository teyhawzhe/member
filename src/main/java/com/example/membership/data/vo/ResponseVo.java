package com.example.membership.data.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@ToString
@Setter
@Getter
public class ResponseVo<T> implements Serializable {

    private int status;

    private T data;

    private String message;

}
