package com.kk.concurrent;

import java.util.function.Function;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-10 10:40
 */
public class CustFunction<T,R> {

    public String getName(){
        String name = "test-"+System.currentTimeMillis();
        System.out.println(name);
        return name;
    }

    public R exec(Function<T,R> f){
        T t = (T) new CustFunction();
        return f.apply(t);
    }

}
