package com.example.java8demo.lambda;

import com.example.java8demo.lambda.builder.IndicatorBuilder;
import com.example.java8demo.lambda.builder.IndicatorGenerator;
import com.example.java8demo.lambda.builder.InventoryResponse;
import com.example.java8demo.pojo.BizProductRecord;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo01BuilderAndGenerator {

    @Test
    void test01(){
        // IndicatorBuilder.using(new IndicatorGenerator())
        //         .named("")
        //         .required(new InventoryResponse())
                // .required(new BizProductRecord())
                // .createData()
                // .toResponse();
    }
}
