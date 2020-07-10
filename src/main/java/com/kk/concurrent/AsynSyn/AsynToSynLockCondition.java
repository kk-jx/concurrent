package com.kk.concurrent.AsynSyn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-10 11:10
 */
public class AsynToSynLockCondition implements CallBack {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        AsynToSynLockCondition asynToSynLockCondition = new AsynToSynLockCondition();
        DataThread dataThread = new DataThread(asynToSynLockCondition);
        dataThread.start();//dataThread.run();这样就变成了同步了
        try {
            asynToSynLockCondition.lock.lock();
            try {
                asynToSynLockCondition.condition.await();//Condition是使用await方法阻塞，signalAll释放阻塞，Object中使用的是wait阻塞，notifyAll唤醒,需要配合管程synchronized使用
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("最后一步");
        } finally {
            asynToSynLockCondition.lock.unlock();
        }
    }

    @Override
    public Object callBack(Object obj) {
        lock.lock();
        try {
            condition.signalAll();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
