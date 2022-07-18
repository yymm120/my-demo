package com.example;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

public class Demo04JCL {

    /**
     * Step1: 添加Log4j依赖到pom.xml中, 运行
     * Step2: 删除Log4j依赖, 再次运行
     * 结论: getLog()会智能的根据依赖选择日志工具.
     * (注意: JCL已经停止维护, Spring-JCL是Spring将JCL内置到Spring中进行更新, Spring-JCL通过Slf4j解决日志统一,解决历史遗留问题)
     */
    @Test
    void testJCL(){
        /* JCL是早期的日志统一方案 */
        /* 通过Class.getForName()的方式统一日志.
        *   private static final String LOGGING_IMPL_LOG4J_LOGGER = "org.apache.commons.logging.impl.Log4JLogger";
            private static final String LOGGING_IMPL_JDK14_LOGGER = "org.apache.commons.logging.impl.Jdk14Logger";
            private static final String LOGGING_IMPL_LUMBERJACK_LOGGER = "org.apache.commons.logging.impl.Jdk13LumberjackLogger";
        */
        Log logger = LogFactory.getLog("a");
        logger.info("jcl");

    }
}
