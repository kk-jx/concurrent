package com.kk.concurrent;

import static org.junit.Assert.assertTrue;

import com.kk.concurrent.singleton.SingletonTestThread;
import org.junit.Test;

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

}
