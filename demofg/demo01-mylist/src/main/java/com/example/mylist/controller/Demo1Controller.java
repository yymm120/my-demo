package com.example.mylist.controller;


import com.example.mylist.entity.BizProductRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class Demo1Controller {

    private static Logger logger = LoggerFactory.getLogger(Demo1Controller.class.getName());

    // @Autowired
    // private PageService pageService;
    //
    // @Autowired
    // private InventoryService inventoryService;
    //
    // @Autowired
    // private WharehouseService wharehouseService;

    @Autowired
    private ResourceLoader resourceLoader;


    @RequestMapping("/test1")
    @ResponseBody
    public String test1(Map<String, Object> map) throws InterruptedException {
        // String abc = inventoryService.getABC();
        // System.out.println(abc);
        logger.info("test1");
        return "test1";
    }




    @PostMapping("/test2")
    @ResponseBody
    public String test2(@RequestParam Map<String, Object> map){
        logger.info("test2");
        return "test2";
    }


    @PostMapping("/test3")
    @ResponseBody
    public String test3(@RequestBody BizProductRecord record){
        logger.info("test2");
        return "test2";
    }


}
