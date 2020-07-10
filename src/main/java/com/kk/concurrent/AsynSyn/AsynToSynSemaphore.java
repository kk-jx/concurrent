package com.kk.concurrent.AsynSyn;

import java.util.concurrent.Semaphore;

/**
 * Created by kk on 2020/7/10.
 */
public class AsynToSynSemaphore implements CallBack {

    private final Semaphore semaphore = new Semaphore(1);//利用只允许一个线程进入，互斥性

    public static void main(String[] args) {
        AsynToSynSemaphore asynToSynSemaphore = new AsynToSynSemaphore();
        AsynCall asynCall = new AsynCall();
        try {
            asynToSynSemaphore.semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asynCall.asynCall(asynToSynSemaphore);

        try {
            asynToSynSemaphore.semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最后一步");
        asynToSynSemaphore.semaphore.release();
    }

    @Override
    public Object callBack(Object obj) {
        semaphore.release();
        return null;
    }
}
