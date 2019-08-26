package com.example.demo.designpattern.dp02_gof.gof01_creating.c03builder;

/**
 * Created by wangshu on 2019/8/7.
 */
//产品(Product)
public class Computer {//CPU 、主板以及内存
    private String myCPU;
    private String mMainboard;
    private String mRam;

    public void setMyCPU(String myCPU) {
        this.myCPU = myCPU;
    }

    public void setmMainboard(String mMainboard) {
        this.mMainboard = mMainboard;
    }

    public void setmRam(String mRam) {
        this.mRam = mRam;
    }
}
