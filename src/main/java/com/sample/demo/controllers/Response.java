package com.sample.demo.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response<T> {
    @JsonProperty("code")
    String code;

    @JsonProperty("data")
    T data;
}
