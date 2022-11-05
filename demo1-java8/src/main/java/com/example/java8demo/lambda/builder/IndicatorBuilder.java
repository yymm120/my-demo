package com.example.java8demo.lambda.builder;


import com.example.java8demo.pojo.BizProductRecord;

// import java.beans.BeanProperty;
import java.util.List;
import java.util.function.UnaryOperator;


public class IndicatorBuilder {

    private IndicatorGenerator generator;
    private BizProductRecord record;

    public IndicatorBuilder named(String s) {
        return this;
    }

    public IndicatorBuilder required(InventoryResponse inventoryResponse) {
        return this;
    }

    static class IndicatorGenerator{
        List<String> list;
        public IndicatorGenerator() {
        }
    }

    /**
     * 1. build properties
     * 2. toResponse
     * 3.
     */


    public IndicatorBuilder(IndicatorGenerator generator) {
        this.record = record;
    }




    public static IndicatorBuilder using(com.example.java8demo.lambda.builder.IndicatorGenerator generator){
        return null;
    }



    public UnaryOperator<Boolean> mmm(){
        return ((a) -> {
            return true;
        });
    }




    public void buildLimitedStock(boolean limited, UnaryOperator<Boolean> op){

    }



    public BizProductRecord getRecord() {
        return record;
    }



    public void setRecord(BizProductRecord record) {
        this.record = record;
    }
}