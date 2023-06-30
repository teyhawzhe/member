package com.example.membership.enums;

public enum Sex {
    MALE(1), FAMALE(0);

    private int code;

    Sex(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
