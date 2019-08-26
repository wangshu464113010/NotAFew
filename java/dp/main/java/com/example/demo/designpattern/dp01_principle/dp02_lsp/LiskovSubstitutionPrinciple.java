package com.example.demo.designpattern.dp01_principle.dp02_lsp;

/**
 * Created by wangshu on 2019/8/7.
 * 里氏替换原则(Liskov Substitution Principle)
 * 里氏替换原则（Liskov Substitution Principle，LSP）由麻省理工学院计算机科学实验室的里斯科夫（Liskov）女士
 * 在 1987 年的“面向对象技术的高峰会议”（OOPSLA）上发表的一篇文章《数据抽象和层次》
 * （Data Abstraction and Hierarchy）里提出来的，她提出：继承必须确保超类所拥有的性质在子类中仍然成立
 * （Inheritance should ensure that any property proved about supertype objects also holds for subtype objects）。
 *    里氏替换原则通俗来讲就是：子类可以扩展父类的功能，但不能改变父类原有的功能
 *
 *  (所有引用基类的地方必须能透明地使用其子类的对象。)
 *  子类对象替换父类对象对程序没有影响
 ***************************************
 * 里氏替换原则的主要作用如下。
 * 里氏替换原则是实现开闭原则的重要方式之一。
 * 它克服了继承中重写父类造成的可复用性变差的缺点。
 * 它是动作正确性的保证。即类的扩展不会给已有的系统引入新的错误，降低了代码出错的可能性
 *
 */
public class LiskovSubstitutionPrinciple {
}
class A{
    private String s;
    private double c = 100.0;
    public strictfp double sum(double a,double b){
        return a+b;
    }
}
class B extends A{//里氏替换原则规定子类不能改变超类原有的功能，不能重写其方法
}
/**
 * Ps:关于对strictfp <tt>strict float point(精确浮点)</tt> 关键字的解释
 * JDK1.2，Java语言增加了一个关键字strictfp。strictfp的意思是FP-strict，也就是说精确浮点的意思。
 * 在Java虚拟机进行浮点运算时，如果没有指定strictfp关键字时，Java的编译器以及运行环境在对浮点运算
 * 的表达式是采取一种近似于我行我素的行为来完成这些操作，以致于得到的结果往往无法令你满意。而一旦使
 * 用了strictfp来声明一个类、接口或者方法时，那么所声明的范围内Java的编译器以及运行环境会完全依照浮
 * 点规范 <tt>IEEE-754</tt> 来执行。因此如果你想让你的浮点运算更加精确，而且不会因为不同的硬件平台所执行的结果
 * 不一致的话，那就请用关键字strictfp。
 * 可以将一个类、接口以及方法声明为strictfp，但是不允许对接口中的方法以及构造函数声明strictfp关键字。
 *
 */