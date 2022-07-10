package com.example.mylist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@SpringBootTest
public class Demo01Pagination {

    /**
     * Demo1, pagination
     */
    @Test
    void test1() throws JsonProcessingException {
        System.out.println("hello");
        Function<String, String> paginationFunction = (String s) -> {
            return s;
        };

        String a = paginationFunction.apply("");
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        List<List<String>> partition = Lists.partition(list, 2);
        // first page
        List<String> page1 = partition.get(0);
        List<String> page2 = partition.get(1);
        // total page number
        
        int pageNum = partition.size();
        // total number for items
        int totalNums = list.size();

        System.out.println(new ObjectMapper().writeValueAsString(partition));
    }

    /**
     * Demo2, optimization when first call service
     */
    @Test
    void test2(){
        String[] split = "sabcsddsdagddafdsagagsdsdf".split(" |,|_|~|%|/|\\+");

        Arrays.stream(split).forEach(System.out::println);
    }

    /**
     * search function demo
     */
    @Test
    void test3(){
        // items contains info: name, po, ss, ak;
        List<String> itemsDetails = Arrays.asList("");
        List<String> keywords = Arrays.asList("asd", "asa", " sd", "sdfa");

    }
}
