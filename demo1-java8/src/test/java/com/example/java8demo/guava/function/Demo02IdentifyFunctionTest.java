package com.example.java8demo.guava.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Demo02IdentifyFunctionTest {

    @Test
    void test01_IdentityFunction1(){
        Function<Long, Long> identity = Functions.identity();
        Long apply = identity.apply(123L);
        if (apply == 123L){
            System.out.println("Identify返回其本身");
        }
    }

    @Test
    void test02_IdentifyFunction2(){
        Function<Long, Long> identity = Functions.identity();
        Long aLong = new Long(123L);
        Long apply = identity.apply(aLong);
        Long apply1 = identity.apply(new Long(123L));
        System.out.println(aLong.equals(apply));
        System.out.println(aLong.equals(apply1));
    }

    @Test
    void test03_IdentifyFunction3(){
        Function<Long, Long> identity = Functions.identity();
        // Long apply = identity.apply(new Long(123L));
        System.out.println(new Long(123L).equals(identity.apply(123L)));
        // org.apache.commons.lang3.Functions.asBiFunction()

    }

}
