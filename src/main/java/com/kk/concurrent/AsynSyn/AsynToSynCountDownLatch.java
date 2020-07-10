package com.kk.concurrent.AsynSyn;

import java.util.concurrent.CountDownLatch;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-10 18:26
 */
public class AsynToSynCountDownLatch implements CallBack {

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        AsynToSynCountDownLatch asynToSynCountDownLatch = new AsynToSynCountDownLatch();
        AsynCall asynCall = new AsynCall();
        asynCall.asynCall(asynToSynCountDownLatch);//一步开线程
        try {
            asynToSynCountDownLatch.countDownLatch.await();//阻塞当前线程，直到计数器的值为0
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("最后一步");
    }

    @Override
    public Object callBack(Object obj) {
        countDownLatch.countDown();//当前线程调用此方法，计数器减一
        return null;
    }
}
