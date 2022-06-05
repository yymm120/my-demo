package com.demospring.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Log {

    private Logger logger = LogManager.getLogger(Log.class.getName());
    /**
     * 前置增强
     */
    public void before(JoinPoint joinPoint) {
        System.out.println("前置增强被调用");
        showLogInfo(joinPoint);
    }

    /**
     * 后置增强
     */
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("后置增强被调用");
        System.out.println("目标方法的返回值: " + result);
        showLogInfo(joinPoint);
    }

    public void after(JoinPoint joinPoint){
        System.out.println("最终增强被调用");
    }

    public void afterThrowing(JoinPoint joinPoint, Exception e){
        System.out.println("异常抛出增强被调用");
        e.printStackTrace();
    }

    /**
     * 环绕增强
     */
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕增强》》》》》》》》》模拟1.前置增强");

        Object proceed = null;
        try {
            //放行，交给目标程序运行，返回值即为目标程序运行后的返回值，捕获的异常即为目标抛出的异常
            proceed = joinPoint.proceed();

            System.out.println("环绕增强》》》》》》》》》模拟2.后置增强：" + proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();

            System.out.println("环绕增强》》》》》》》》》模拟3.异常抛出增强：" + throwable.getMessage());
        } finally {
            System.out.println("环绕增强》》》》》》》》》模拟4.最终增强");
        }

        //显示目标信息
        return proceed;
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
