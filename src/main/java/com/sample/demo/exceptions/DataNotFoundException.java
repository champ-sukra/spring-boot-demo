package com.sample.demo.exceptions;

import lombok.Getter;

@Getter
public class DataNotFoundException extends Exception {
    private String errorCode;

    public DataNotFoundException(String errorCode) {
        this.errorCode = errorCode;
    }
}
