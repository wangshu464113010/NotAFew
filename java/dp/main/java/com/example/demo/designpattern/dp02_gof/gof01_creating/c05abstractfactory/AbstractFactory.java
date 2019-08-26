package com.example.demo.designpattern.dp02_gof.gof01_creating.c05abstractfactory;

/**
 * Created by wangshu on 2019/8/7.
 * 抽象工厂（AbstractFactory）模式的定义：是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 * 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
 *
 * 使用抽象工厂模式一般要满足以下条件。
 *     系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 *     系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 * 角色：
 *     抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
 *     具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
 *     抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
 *     具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它 同具体工厂之间是多对一的关系。
 *工厂方法与抽象工厂的区别
 * 工厂方法模式中考虑的是一类产品的生产，如畜牧场只养动物、电视机厂只生产电视机等。
 * 同种类称为同等级，也就是说：工厂方法模式只考虑生产同等级的产品，但是在现实生活中许多工厂是综合型的工厂，能生产多等级（种类） 的产品，
 * 如农场里既养动物又种植物，电器厂既生产电视机又生产洗衣机或空调，大学既有信息与计算科学专业又有应用数学专业等
 */
public interface AbstractFactory {

    Product1 newObject1();//产品1
    Product2 newObject2();//产品2
}
