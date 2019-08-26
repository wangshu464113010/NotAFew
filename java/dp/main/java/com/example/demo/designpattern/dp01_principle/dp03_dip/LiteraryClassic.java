package com.example.demo.designpattern.dp01_principle.dp03_dip;

/**
 * Created by wangshu on 2019/8/7.
 */
//文学经典
public class LiteraryClassic implements BookRead {

    @Override
    public void read() {
        System.out.println("\"文学经典阅读，滋润自己的内心心灵\"");
    }
}
