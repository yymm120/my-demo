package com.pojo;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@JsonRootName(value = "JsonRoot")
@Data
public class Test {
    private String field01;
}
