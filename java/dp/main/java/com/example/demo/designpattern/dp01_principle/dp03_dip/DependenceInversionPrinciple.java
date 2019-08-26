package com.example.demo.designpattern.dp01_principle.dp03_dip;

/**
 * Created by wangshu on 2019/8/7.
 * 依赖倒置原则(Dependence Inversion Principle)
 *
 * 依赖倒置原则（Dependence Inversion Principle，DIP）是 Object Mentor 公司总裁罗伯特·马丁（Robert C.Martin）于 1996 年在 C++ Report 上发表的文章。
 * 依赖倒置原则的原始定义为：高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象
 * （High level modules shouldnot depend upon low level modules.Both should depend upon abstractions.Abstractions should
 * not depend upon details. Details should depend upon abstractions）。其核心思想是：要面向接口编程，不要面向实现编程。
 *   依赖倒置原则是实现开闭原则的重要途径之一，它降低了客户与实现模块之间的耦合。
 * ****************************************************
 *依赖倒置原则的主要作用如下：
 * 依赖倒置原则可以降低类间的耦合性。
 * 依赖倒置原则可以提高系统的稳定性。
 * 依赖倒置原则可以减少并行开发引起的风险。
 * 依赖倒置原则可以提高代码的可读性和可维护性。
 * ****************************************************
 *依赖倒置原则的目的是通过要面向接口的编程来降低类间的耦合性，所以我们在实际编程中只要遵循以下4点，就能在项目中满足这个规则。
 *    每个类尽量提供接口或抽象类，或者两者都具备。
 *    变量的声明类型尽量是接口或者是抽象类。
 *    任何类都不应该从具体类派生。
 *    使用继承时尽量遵循里氏替换原则。
 * *****************************************************
 * 依赖的实现
 *  1.构造函数传递依赖对象
 *  2.setter方法传递依赖对象
 *  3.接口声明依赖(其方法也叫做接口注入)
 */
public class DependenceInversionPrinciple {//本案例使用接口声明依赖

    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        BookRead novel = new Novel();
        xiaoMing.read(novel);
        BookRead literaryClassic = new LiteraryClassic();
        xiaoMing.read(literaryClassic);
    }
}
