package com.example.mylist;

import com.example.mylist.controller.MyListAction;
import com.example.mylist.controller.MyListItemAction;
import com.example.mylist.entity.BizProductRecord;
import com.example.mylist.entity.MyListProductRecord;
import com.example.mylist.entity.ProductRecord;
import com.example.mylist.entity.RecordIndicatorBuilder;
import com.example.mylist.handler.HandlerSyncChain;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.support.ReflectionHelper;

import java.lang.reflect.Method;
import java.util.*;

@SpringBootTest
public class Demo02Translate {

    @Test
    void test01(){
        BizProductRecord bizProductRecord = new BizProductRecord(false, false, false, false, 1, false, "", false, false);

        List<ProductRecord> productRecords = Arrays.asList(new ProductRecord(), new ProductRecord(), new ProductRecord());
        // List<BizProductRecord> bizProductRecords = Arrays.asList(productRecords.toArray(new BizProductRecord[0]));

        List<BizProductRecord> list = new ArrayList<>();
        Collections.addAll(list, productRecords.toArray(new BizProductRecord[0]));
    }

    @Test
    void test02(){
        // RecordIndicatorBuilder<MyListProductRecord> recordIndicatorBuilder = RecordIndicatorBuilder.getRecordIndicatorBuilder(new MyListProductRecord());

        System.out.println("a");
    }









}
