package com.sample.demo.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TaskRequest {
    @JsonProperty("title")
    String title;
}
