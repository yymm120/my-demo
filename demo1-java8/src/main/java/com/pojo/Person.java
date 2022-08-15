package com.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@ToString
public class Person {

    @NotNull
    private String name;
    @NotNull
    @Range(min = 10, max = 40)
    private Integer age;

    @NotNull
    @Size(min = 3, max = 5)
    private List<String> hobbies;

    // 级联校验
    @Valid
    @NotNull
    private Child child;
}