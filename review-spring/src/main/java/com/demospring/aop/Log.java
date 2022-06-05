package com.demospring.aop;






public class Log {

    private long start;

    /**
     * 前置增强
     */
    public void before() {
        //获取当前时间戳（当前时间距离1970年1月1日0），单位：毫秒数
        start = System.currentTimeMillis();

        Double time = Math.random() * 100;
        try {
            Thread.sleep(time.longValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法执行前时间戳：" + start);
    }

    /**
     * 后置增强
     */
    public void afterReturning() {
        long end = System.currentTimeMillis();
        System.out.println("方法执行后时间戳：" + end);
        System.out.println("执行耗时：" + (end - start));
    }
}
