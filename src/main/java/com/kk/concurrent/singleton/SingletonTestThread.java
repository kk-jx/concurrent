package com.kk.concurrent.singleton;

/**
 * 单例 模拟spring
 * Create By Zhenli.Hu
 * Create Time 2020-07-09 9:29
 */
public class SingletonTestThread {

    private SingletonTestThread(){}

    public static SingletonTestThread getInstance(){
        return InnerTest.singletonTestThread;
    }

    private static class InnerTest{
        private final static SingletonTestThread singletonTestThread = new SingletonTestThread();
    }

    /**
     * requestBean本身没有现成安全问题，但对应的类如果有全局变量，就有线程安全问题
     * 所有编写程序考虑是否线程安全，主要有类为单位，考虑每个类是否有全局变量，有共用全局变量，这个时候就要考虑并发问题
     * @param requestBean
     */
    public void exec(RequestBean requestBean){
        /**
         * RequestBean单例，存在线程安全问题
         */
        RequestBean requestBean1 = new RequestBean();
        requestBean1.setParam(requestBean.getParam()+"1");
        System.out.println(Thread.currentThread().getName().equals(requestBean1.getParam()));//one-----two-01594259644450
    }

}
