package com.example.mylist.controller;


import com.example.mylist.Annotation.MyListMapping;
import com.example.mylist.entity.MyListItemResponse;
import com.example.mylist.entity.MyListResponse;
import com.example.mylist.service.impl.MyListItemActuator;
import com.example.mylist.service.impl.MyListItemRequest;


@MyListMapping("/mylist")
public class MyListItemAction implements MyListAction{
    private MyListItemRequest request;
    private MyListItemActuator actuator = new MyListItemActuator();
    private MyListItemResponse response;



    @MyListMapping("/update")
    public MyListResponse updateQty(String a) {
        // System.out.println("into /update");
        actuator.mylistcheckRequest();
        actuator.mylistUpdateQty();
        // System.out.println("leave /update");
        // System.out.println(a);
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
