package com.kk.concurrent.singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-09 9:29
 */
public class SingletonTestThread {

    private final static ReentrantLock reentrantLock = new ReentrantLock();


    public void exec(RequestBean requestBean){
        /**
         * RequestBean单例，存在线程安全问题
         */
        System.out.println(Thread.currentThread().getName()+"-----"+requestBean.getParam());//one-----two-01594259644450
    }

    public class OneThread extends Thread{
        @Override
        public void run() {
            try {
                for (int i=0;i<1000;i++) {
                    RequestBean requestBean = RequestBean.getInstance();
                    try {
                        reentrantLock.lock();
                        requestBean.setParam("one-"+i+System.currentTimeMillis());
                        exec(requestBean);
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class TwoThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<1000;i++){
                RequestBean requestBean = RequestBean.getInstance();
                try {
                    reentrantLock.lock();
                    requestBean.setParam("two-"+i+System.currentTimeMillis());
                    exec(requestBean);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

}
