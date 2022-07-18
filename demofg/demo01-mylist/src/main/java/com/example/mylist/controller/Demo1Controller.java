package com.example.mylist.controller;


import com.example.mylist.service.InventoryService;
import com.example.mylist.service.PageService;
import com.example.mylist.service.WharehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Demo1Controller {

    @Autowired
    private PageService pageService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private WharehouseService wharehouseService;

    @Autowired
    private ResourceLoader resourceLoader;


    @RequestMapping("/test1")
    @ResponseBody
    public String test1() throws InterruptedException {
        String abc = inventoryService.getABC();
        System.out.println(abc);
        return "test1";
    }



    @RequestMapping("/test2")
    @ResponseBody
    public String test2(){
        return "test2";
    }


}
