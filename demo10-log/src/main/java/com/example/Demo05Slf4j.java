package com.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo05Slf4j {

    /**
     * Step0: 使用Plugin生成log4j1, log4j2, logback的配置文件.
     * Step1: 添加Slf4j依赖, 运行代码 : 报错会提示没有找到默认的绑定器.
     * Step2: 添加slf4j-log4j1绑定器依赖. 运行代码 : log4j1工作. (实际上只需要添加绑定器依赖, maven有依赖传递的概念)
     * Step3: 注释slf4j-log4j绑定器, 添加Slf4j-log4j2绑定器, 运行代码  : log4j2工作
     * Step4: 注释slf4j-log4j2绑定器, 添加slf4j-logback绑定器, 运行代码 : logback工作
     * 结论: 通过绑定器统一日志
     */
    @Test
    void testSlf4j_01(){
        /* 现在普遍使用日志统一方案, Spring-jcl也是使用这个方案 */
        Logger logger = LoggerFactory.getLogger("a");
        logger.info("Slf4j");
    }

    /**
     * 历史遗留问题: 老项目使用Log4J2, 现在使用slf4j-logback绑定器. 此时Log4J2和logback会同时工作.
     *  - Slf4j通过桥接器解决历史遗留问题
     * Step1: Reproduce - 注释掉其他绑定器, 添加slf4j-logback绑定器, 添加log4j2依赖, 运行代码 : 两种日志工具同时工作
     * Step2: Solution  - 添加log4j-to-slf4j桥接器, 运行代码 : log4j2桥接为logback, 并且统一使用logback.xml的配置
     */
    @Test
    void testSlf4j_02(){
        Logger logger = LoggerFactory.getLogger("a");
        logger.info("logback");

        ExtendedLogger logger1 = LogManager.getContext().getLogger("a");
        logger1.info("log4j2");

    }

    /**
     * 绑定器冲突: 一个项目中存在多个绑定器, 那么使用pom依赖中的第一个绑定器
     *  - 当有多个绑定器的时候, 会报一个警告, 但不影响日志输出
     * Step1: 添加两个绑定器, 运行代码 : 日志正常打印, 但会报一个警告.
     * 结论:
     * 在使用框架的时候, 框架可能内置有一个绑定器, 如果要解决这个警告, 就应该从依赖中入手, 保证运行时只有一个绑定器依赖.
     * Spring非常喜欢log4j2, 就算在Spring源码上把log4j2依赖注释掉, 但只要引入的其他依赖包含了log4j2, Spring也会使用Log4j2.
     * 一劳永逸的解决办法: 使用log4j-slf4j桥接器, 有log4j2则桥接器生效, 没有log4j2则桥接器不生效.
     */
    @Test
    void testSlf4j_03(){
        Logger logger = LoggerFactory.getLogger("a");
        logger.info("logback");
    }
}
