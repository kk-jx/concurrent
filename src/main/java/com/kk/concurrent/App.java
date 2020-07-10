package com.kk.concurrent;


import com.kk.concurrent.singleton.SingletonTestThread;

/**
 * Hello world!
 *
 */
public class App 
{
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


        SingletonTestThread singletonTestThread = new SingletonTestThread();
        SingletonTestThread.OneThread oneThread = singletonTestThread.new OneThread();
        oneThread.setName("one");
        SingletonTestThread.TwoThread twoThread = singletonTestThread.new TwoThread();
        twoThread.setName("two");

        try {
            oneThread.start();
            twoThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
