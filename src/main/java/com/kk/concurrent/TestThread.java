package com.kk.concurrent;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-08 11:33
 */
public class TestThread{

    public void exec(String name){
        System.out.println(Thread.currentThread().getName()+"-----"+name);
    }


    class OneThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<500;i++) {
                exec("one-" + System.currentTimeMillis());
            }
        }
    }

    class TwoThread implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<500;i++){
                exec("two-"+System.currentTimeMillis());
            }
        }
    }


}
