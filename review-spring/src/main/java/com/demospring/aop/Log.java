package com.demospring.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class Log {

    private Logger logger = LogManager.getLogger(Log.class.getName());
    /**
     * 前置增强
     */
    public void before(JoinPoint joinPoint) {
        showLogInfo(joinPoint);
    }

    /**
     * 后置增强
     */
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("目标方法的返回值: " + result);
        showLogInfo(joinPoint);
    }

    private void showLogInfo(JoinPoint joinPoint) {
        /* 获取目标对象 */
        logger.info(joinPoint.getTarget());
        /* 获取参数 */
        logger.info(joinPoint.getArgs());
        /* 获取方法签名 */
        logger.info(joinPoint.getSignature().getName());
    }
}
