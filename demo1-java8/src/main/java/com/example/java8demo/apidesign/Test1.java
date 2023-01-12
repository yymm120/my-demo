package com.example.java8demo.apidesign;

import com.example.java8demo.pojo.GroupFolder;
import com.example.java8demo.pojo.MyGiftListDescInfoData;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootTest
public class Test1 {
    @Test
    void test1(){
        List<String> groups = Arrays.asList("a", "b", "c");
        GroupFolder groupFolder = new GroupFolder();
        System.out.println(groups);
        groups.stream().map(c -> {
            return c;
        });
        List<GroupFolder.Group> abc = groups.stream().map((group) -> {
            // step1: filter empty group
            ArrayList<String> lists = new ArrayList<>();
            System.out.println("abc" + group);
            return ImmutablePair.of(group, lists);
        }).peek(System.out::println).filter(Objects::nonNull).map((pair) -> {
            // step2: assemble group
            String groupId = "123";
            MyGiftListDescInfoData myGiftListDescInfoData = new MyGiftListDescInfoData();
            ArrayList<MyGiftListDescInfoData> myGiftListDescInfoData1 = new ArrayList<>();
            return new GroupFolder.Group("abc", groupId, myGiftListDescInfoData1);
            // step3: generate groupFolder
        }).collect(Collectors.toList());
        System.out.println(abc);
    }
}
