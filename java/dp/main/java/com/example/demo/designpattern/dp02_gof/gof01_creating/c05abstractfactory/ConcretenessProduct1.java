package com.example.demo.designpattern.dp02_gof.gof01_creating.c05abstractfactory;

/**
 * Created by wangshu on 2019/8/8.
 */
public class ConcretenessProduct1 implements Product1 {//抽象产品1下的具体产品1

    @Override
    public void show() {
        System.out.println(ConcretenessProduct1.class.getName());
    }
}
