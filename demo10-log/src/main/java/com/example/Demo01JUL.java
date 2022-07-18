package com.example;


import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class Demo01JUL {

    @Test
    void testJul(){
        /* 1. JUL */
        Logger logger = Logger.getLogger("a");
        logger.info("jul");
    }
}
