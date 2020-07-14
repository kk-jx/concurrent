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


    public void exec(RequestBean requestBean){
        /**
         * RequestBean单例，存在线程安全问题
         */
        requestBean.setParam(requestBean.getParam()+"1");
        System.out.println(Thread.currentThread().getName().equals(requestBean.getParam()));//one-----two-01594259644450
    }

}
