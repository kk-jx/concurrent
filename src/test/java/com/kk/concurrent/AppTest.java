package com.kk.concurrent;

import static org.junit.Assert.assertTrue;

import com.kk.concurrent.singleton.SingletonTestThread;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void functionTest(){
        CustFunction<CustFunction,String> function = new CustFunction();
        function.exec(t->{
            return t.getName();
        });
    }

    @Test
    private void threadPoolTest(){
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,20,5, TimeUnit.MINUTES,blockingQueue);
//        threadPoolExecutor.execute();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

    }

}
