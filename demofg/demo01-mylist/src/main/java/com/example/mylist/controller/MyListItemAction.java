package com.example.mylist.controller;


import com.example.mylist.Annotation.MyListMapping;
import com.example.mylist.entity.MyListItemResponse;
import com.example.mylist.entity.MyListResponse;
import com.example.mylist.service.impl.MyListItemActuator;
import com.example.mylist.service.impl.MyListItemRequest;


@MyListMapping
public class MyListItemAction implements MyListAction{
    private MyListItemRequest request;
    private MyListItemActuator actuator;
    private MyListItemResponse response;



    @MyListMapping("/update")
    public MyListResponse updateQty() {
        actuator.mylistcheckRequest();
        actuator.mylistUpdateQty();
        return actuator.mylistgeneratResponse();
    }


    @MyListMapping("/add")
    @Override
    public MyListResponse addItemToCart() {

        return null;
    }

    @MyListMapping("/delete")
    @Override
    public MyListItemRequest deleteItem(){
        return null;
    }
}
