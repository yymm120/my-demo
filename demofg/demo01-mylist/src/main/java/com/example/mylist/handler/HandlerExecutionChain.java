package com.example.mylist.handler;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class HandlerExecutionChain implements HandlerSyncChain {


    public HandlerExecutionChain(Object handler) {

    }



    @Override
    public HandlerSyncChain handle() {
        return null;
    }

}
