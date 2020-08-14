package com.kk.concurrent.callable;

import java.util.concurrent.Callable;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-08-14 17:18
 */
public class CallableDemo {

    public static void main(String[] args) throws Exception {
        CallableDemo callableDemo = new CallableDemo();
        callableDemo.callMethod();
    }

    private void callMethod() throws Exception {
        String param = "函数整个内容作为另外一个函数的参数案例";
        Object rs = calledMethod("我是方法calledMethod的第一个参数", new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return param+"------------";//写成内部类的方式的一个好处就是可以直接使用所在外部方法的变量
            }
        });
        System.out.println("callMethod方法打印--》》"+rs);
    }

    public Object calledMethod(Object obj, Callable<Object> callMethod) throws Exception {
        System.out.println("calledMethod方法打印--》"+obj);
        Object call = callMethod.call();
        return call;
    }

}
