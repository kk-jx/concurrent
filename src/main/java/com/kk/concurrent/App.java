package com.kk.concurrent;


import com.kk.concurrent.singleton.RequestBean;
import com.kk.concurrent.singleton.SingletonTestThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App {
    private final static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main( String[] args ) {
//        TestThread testThread = new TestThread();
//        TestThread.OneThread oneThread = testThread.new OneThread();
//        oneThread.setName("one");
//        TestThread.TwoThread twoRunnable = testThread.new TwoThread();
//        Thread twoThread = new Thread(twoRunnable);
//        twoThread.setName("two");
//
//        oneThread.start();
//        twoThread.start();


        Thread oneThread = new Thread(()->{
            for (int i=0;i<100000;i++) {
//                RequestBean requestBean = RequestBean.getInstance();
                RequestBean requestBean = new RequestBean();
                try {
//                    reentrantLock.lock();
                    SingletonTestThread singletonTestThread = SingletonTestThread.getInstance();
//                    SingletonTestThread singletonTestThread = new SingletonTestThread();
                    requestBean.setParam("one");
                    singletonTestThread.exec(requestBean);
                } finally {
//                    reentrantLock.unlock();
                }
            }
        });
        oneThread.setName("one1");
        Thread twoThread = new Thread(()->{
            for (int i=0;i<100000;i++) {
//                RequestBean requestBean = RequestBean.getInstance();
                RequestBean requestBean = new RequestBean();
                try {
//                    reentrantLock.lock();
                    SingletonTestThread singletonTestThread = SingletonTestThread.getInstance();
//                    SingletonTestThread singletonTestThread = new SingletonTestThread();
                    requestBean.setParam("two");
                    singletonTestThread.exec(requestBean);
                } finally {
//                    reentrantLock.unlock();
                }
            }
        });
        twoThread.setName("two1");

        try {
            twoThread.start();
            oneThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
