package com.kk.concurrent.AsynSyn;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-10 11:12
 */
public class AsynCall {

    public void asynCall(CallBack callBack){
        new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println("------AsynCall");
                callBack.callBack(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
