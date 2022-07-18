package com.example;


import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;


public class Demo02Log4j {

    @Test
    void testLog4j(){
        Logger logger1 = Logger.getLogger("a");
        logger1.error("log4j");
    }
}
