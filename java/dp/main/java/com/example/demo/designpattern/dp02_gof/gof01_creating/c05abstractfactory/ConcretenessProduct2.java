package com.example.demo.designpattern.dp02_gof.gof01_creating.c05abstractfactory;

/**
 * Created by wangshu on 2019/8/8.
 */
public class ConcretenessProduct2 implements Product2{//抽象产品2下的具体具体产品
    @Override
    public void show() {
        System.out.println(ConcretenessProduct2.class.getName());
    }
}
