package com.example.demo.designpattern.dp01_principle.dp03_dip;

/**
 * Created by wangshu on 2019/8/7.
 */
//小说
public class Novel implements BookRead {

    @Override
    public void read() {
        System.out.println("阅读小说，放松自己");
    }
}
