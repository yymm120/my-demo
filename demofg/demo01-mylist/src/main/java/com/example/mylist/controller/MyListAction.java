package com.example.mylist.controller;


import com.example.mylist.Annotation.MyListMapping;
import com.example.mylist.entity.MyListResponse;
import com.example.mylist.service.impl.MyListItemRequest;

public interface MyListAction {

    MyListResponse updateQty();

    MyListResponse addItemToCart();

    MyListItemRequest deleteItem();
}
