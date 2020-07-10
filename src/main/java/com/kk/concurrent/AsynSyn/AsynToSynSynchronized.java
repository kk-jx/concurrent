package com.kk.concurrent.AsynSyn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-10 11:10
 */
public class AsynToSynSynchronized implements CallBack {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        AsynToSynSynchronized asynToSynSynchronized = new AsynToSynSynchronized();
        AsynCall asynCall = new AsynCall();
        asynCall.asynCall(asynToSynSynchronized);//一步开线程
        synchronized (asynToSynSynchronized.condition){
            try {
                asynToSynSynchronized.condition.wait();//Condition是使用await方法阻塞，signalAll释放阻塞，Object中使用的是wait阻塞，notifyAll唤醒,需要配合管程synchronized使用
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("最后一步");
        }
    }

    @Override
    public Object callBack(Object obj) {
        synchronized (condition) {
            lock.lock();
            try {
                condition.notifyAll();
            } finally {
                lock.unlock();
            }
        }
        return null;
    }
}
