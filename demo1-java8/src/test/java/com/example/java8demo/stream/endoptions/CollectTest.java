package com.example.java8demo.stream.endoptions;

import com.example.java8demo.pojo.User;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectTest {
    // private MyCollectors myCollectors;


    public static void collectorsFunctionsApi() {
        Collector<Object, ?, List<Object>> toList = Collectors.toList();
        Collector<User, ?, Map<String, Object>> userMapCollector1 = Collectors.toMap(User::getName, Function.identity(), (k1, k2) -> k2);
        Collector<User, ?, Map<String, Object>> userMapCollector2 = Collectors.toMap(User::getName, Function.identity(), (k1, k2) -> k1);
        Collector<User, ?, Map<String, Integer>> userMapCollector3 = Collectors.toMap(User::getName, User::getAge);
        // Collector<Object, ?, Set<Object>> toSet = Collectors.toSet();
        // Collector<Object, ?, Collection<Object>> toCollection = Collectors.toCollection();
        // Collector<Object, ?, ConcurrentMap<Object, Object>> toConcurrentMap = Collectors.toConcurrentMap();
        // Collector<Object, ?, Object> reducing = Collectors.reducing(, , );
        // Collector<Object, ?, Optional<Object>> reducing1 = Collectors.reducing(a);
        // Collector<Object, ?, Object> reducing2 = Collectors.reducing(, );
        // Collector<Object, ?, Long> counting = Collectors.counting();
        // Collector<Object, Object, Object> objectObjectObjectCollector = Collectors.collectingAndThen();
        // Collector<Object, ?, Double> objectDoubleCollector = Collectors.averagingDouble();
        // Collector<Object, ?, Double> objectDoubleCollector1 = Collectors.averagingInt();
        // Collector<Object, ?, Double> objectDoubleCollector2 = Collectors.averagingLong();
        // Collector<Object, ?, Map<Object, Object>> objectMapCollector = Collectors.groupingBy(, );
        // Collector<Object, ?, Map<Object, Object>> objectMapCollector2 = Collectors.groupingBy(, , );
        // Collector<Object, ?, Map<Object, List<Object>>> objectMapCollector3 = Collectors.groupingBy(a);
        // Collector<CharSequence, ?, String> joining1 = Collectors.joining();
        // Collector<CharSequence, ?, String> joining = Collectors.joining(, );
        // Collector<Object, ?, Object> mapping = Collectors.mapping();
        // Collector<Object, ?, Optional<Object>> objectOptionalCollector = Collectors.maxBy();
        // Collector<Object, ?, Optional<Object>> objectOptionalCollector1 = Collectors.minBy();
        // Collector<Object, ?, Map<Boolean, Object>> objectMapCollector1 = Collectors.partitioningBy(, );
        // Collector<Object, ?, DoubleSummaryStatistics> objectDoubleSummaryStatisticsCollector = Collectors.summarizingDouble();
        // Collector<Object, ?, IntSummaryStatistics> objectIntSummaryStatisticsCollector = Collectors.summarizingInt();
        // Collector<Object, ?, LongSummaryStatistics> objectLongSummaryStatisticsCollector = Collectors.summarizingLong();
        // Collector<Object, ?, Double> objectDoubleCollector3 = Collectors.summingDouble();
        // Collector<Object, ?, Integer> objectIntegerCollector = Collectors.summingInt();
        // Collector<Object, ?, Long> objectLongCollector = Collectors.summingLong();
    }


    public static void customCollectors() {
        // 收集元素, 收集为一个对象
    }


    // public MyCollectors getMyCollectors() {
    //     return myCollectors;
    // }
    //
    // public void setMyCollectors(MyCollectors myCollectors) {
    //     this.myCollectors = myCollectors;
    // }
}
