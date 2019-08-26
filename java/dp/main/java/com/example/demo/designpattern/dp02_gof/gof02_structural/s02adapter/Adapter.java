package com.example.demo.designpattern.dp02_gof.gof02_structural.s02adapter;

/**
 * Created by wangshu on 2019/8/8.
 *
 * 适配器模式（Adapter）的定义如下：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口
 * 不兼容而不能一起工作的那些类能一起工作。适配器模式分为类结构型模式和对象结构型模式两种，前者类
 * 之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。
 *
 * 该模式的主要优点如下:
 *     客户端通过适配器可以透明地调用目标接口。
 *     复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
 *     将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。
 * 其缺点是：对类适配器来说，更换适配器的实现过程比较复杂。
 * 适配器模式（Adapter）包含以下主要角色。
 *    目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
 *    适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 *    适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，
 *        把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 *
 * 适配器模式（Adapter）通常适用于以下场景。
 *    以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致。
 *    使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同。
 *
 * 在现实生活中，经常出现两个对象因接口不兼容而不能在一起工作的实例，这时需要
 * 第三者进行适配。例如，讲中文的人同讲英文的人对话时需要一个翻译，用直流电的
 * 笔记本电脑接交流电源时需要一个电源适配器，用计算机访问照相机的 SD 内存卡时
 * 需要一个读卡器等。
 *
 * 扩展：适配器模式（Adapter）可扩展为双向适配器模式，双向适配器类既可以把适配
 *       者接口转换成目标接口，也可以把目标接口转换成适配者接口。
 */
public class Adapter {
    public static void main(String[] args) {
        System.out.println("类适配器模式");
        Target target = new ClassAdapter();
        target.request();
    }

}
interface Target {//目标接口
    public void request();
}
class Adaptee {//适配者接口
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}
class ClassAdapter extends Adaptee implements Target {//类适配器类
    public void request() {
        specificRequest();
    }
}
/******************************************************/
class ObjectAdapter implements Target{//对象适配器类
    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee){this.adaptee = adaptee;}
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}