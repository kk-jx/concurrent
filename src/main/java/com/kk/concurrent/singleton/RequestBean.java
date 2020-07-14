package com.kk.concurrent.singleton;

/**
 * Create By Zhenli.Hu
 * Create Time 2020-07-09 9:18
 */
public class RequestBean {

    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
//
//    private RequestBean(){}
//
//    public static RequestBean getInstance(){
//        return InnerClass.requestBean;
//    }
//
//    private static class InnerClass{
//        private final static RequestBean requestBean = new RequestBean();
//    }

}
