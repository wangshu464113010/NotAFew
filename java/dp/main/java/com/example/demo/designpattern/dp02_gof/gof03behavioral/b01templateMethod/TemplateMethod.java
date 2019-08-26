package com.example.demo.designpattern.dp02_gof.gof03behavioral.b01templateMethod;

/**
 * Created by wangshu on 2019/8/15.
 * 模板方法（Template Method）模式的定义如下：定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，
 * 使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。它是一种类行为型模式。
 *
 * 该模式的主要优点如下。
 * 它封装了不变部分，扩展可变部分。它把认为是不变部分的算法封装到父类中实现，而把可变部分算法由子类继承实现，便于子类继续扩展。
 * 它在父类中提取了公共的部分代码，便于代码复用。
 * 部分方法是由子类实现的，因此子类可以通过扩展方式增加相应的功能，符合开闭原则。
 * 该模式的主要缺点如下。
 * 对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象。
 * 父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度
 *
 * 模板方法模式需要注意抽象类与具体子类之间的协作。它用到了虚函数的多态性技术以及“不用调用我，让我来调用你”的反向控制技术。现在来介绍它们的基本结构。
 * 1. 模式的结构
 * 模板方法模式包含以下主要角色。
 *
 * (1) 抽象类（Abstract Class）：负责给出一个算法的轮廓和骨架。它由一个模板方法和若干个基本方法构成。这些方法的定义如下。
 *      ① 模板方法：定义了算法的骨架，按某种顺序调用其包含的基本方法。
 *      ② 基本方法：是整个算法中的一个步骤，包含以下几种类型。
 *      抽象方法：在抽象类中申明，由具体子类实现。
 *      具体方法：在抽象类中已经实现，在具体子类中可以继承或重写它。
 *      钩子方法：在抽象类中已经实现，包括用于判断的逻辑方法和需要子类重写的空方法两种。
 * (2) 具体子类（Concrete Class）：实现抽象类中所定义的抽象方法和钩子方法，它们是一个顶级逻辑的一个组成步骤。
 *
 */
public class TemplateMethod {
}
//抽象类
abstract class AbstractClass
{
    public void TemplateMethod() //模板方法
    {
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }
    public void SpecificMethod() //具体方法
    {
        System.out.println("抽象类中的具体方法被调用...");
    }
    public abstract void abstractMethod1(); //抽象方法1
    public abstract void abstractMethod2(); //抽象方法2
}
//具体子类
class ConcreteClass extends AbstractClass
{
    public void abstractMethod1()
    {
        System.out.println("抽象方法1的实现被调用...");
    }
    public void abstractMethod2()
    {
        System.out.println("抽象方法2的实现被调用...");
    }
}