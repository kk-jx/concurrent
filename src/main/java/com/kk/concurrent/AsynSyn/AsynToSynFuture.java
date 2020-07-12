package com.kk.concurrent.AsynSyn;

import java.util.concurrent.*;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-10 11:10
 */
public class AsynToSynFuture {
    //创建无边界的阻塞队列，并发高，有OOM异常风险
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        AsynToSynFuture asynToSynFuture = new AsynToSynFuture();
        CustCallable custCallable = asynToSynFuture.new CustCallable();
        Future<Integer> future = asynToSynFuture.executorService.submit(()->{
            Thread.sleep(1000);
            System.out.println("CustCallable-->call()");
            return 1;
        });
//        Future<?> future = asynToSynThird.executorService.submit(() -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println("ExecutorService-->thread ");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        if (!future.isDone() && !future.isCancelled()){
            try {
                Object integer = future.get();//获取结果，若无结果会阻塞至异步计算完成
            } catch (Exception e) {
                e.printStackTrace();
            }
            asynToSynFuture.executorService.shutdown();
        }else{
            asynToSynFuture.executorService.shutdown();
        }
        System.out.println("最后一步");
    }


    class CustCallable implements Callable<Integer>{
        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Integer call() throws Exception {
            System.out.println("CustCallable-->call()");
            return 1;
        }
    }
}
