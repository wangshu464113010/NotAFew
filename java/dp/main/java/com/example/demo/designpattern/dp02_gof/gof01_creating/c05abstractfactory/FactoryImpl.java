package com.example.demo.designpattern.dp02_gof.gof01_creating.c05abstractfactory;


/**
 * Created by wangshu on 2019/8/7.
 */
public class FactoryImpl implements AbstractFactory {//具体工厂
    @Override
    public Product1 newObject1() {
        return new ConcretenessProduct1();
    }

    @Override
    public Product2 newObject2() {
        return new ConcretenessProduct2();
    }
}
