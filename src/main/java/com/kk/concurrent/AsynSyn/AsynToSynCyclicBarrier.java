package com.kk.concurrent.AsynSyn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-10 18:57
 */
public class AsynToSynCyclicBarrier implements CallBack {

    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);//几个线程数，包括主线程，几个线程数就要执行几个cyclicBarrier.await()，否则线程不会停止

    public static void main(String[] args) {
        AsynToSynCyclicBarrier asynToSynCyclicBarrier = new AsynToSynCyclicBarrier();
        AsynCall asynCall = new AsynCall();
        asynCall.asynCall(asynToSynCyclicBarrier);
        try {
            asynToSynCyclicBarrier.cyclicBarrier.await();//计数器加1，并判断是否达到线程数，没有达到就阻塞
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("最后一步");
    }

    @Override
    public Object callBack(Object obj) {
        try {
            cyclicBarrier.await();//计数器加1，并判断是否达到线程数，没有达到就阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        return null;
    }
}
