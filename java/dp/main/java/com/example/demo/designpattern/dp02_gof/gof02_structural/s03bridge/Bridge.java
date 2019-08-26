package com.example.demo.designpattern.dp02_gof.gof02_structural.s03bridge;

/**
 * Created by wangshu on 2019/8/8.
 * 现实生活中，某些类具有两个或多个维度的变化，如图形既可按形状分，又可按颜色分。
 * 如何设计类似于 Photoshop 这样的软件，能画不同形状和不同颜色的图形呢？如果用
 * 继承方式，m 种形状和 n 种颜色的图形就有 m×n 种，不但对应的子类很多，而且扩展困难。
 *
 * 桥接（Bridge）模式的定义如下：将抽象与实现分离，使它们可以独立变化。它是用组合关
 * 系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
 * 桥接（Bridge）模式的优点是：
 *     由于抽象与实现分离，所以扩展能力强；
 *     其实现细节对客户透明。
 * 缺点是：由于聚合关系建立在抽象层，要求开发者针对抽象化进行设计与编程，这增加了系统的理解与设计难度。
 * ***********聚合关系建立在抽象层************************
 * 桥接（Bridge）模式包含以下主要角色。
 *     抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
 *     扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 *     实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
 *     具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。
 *
 */
public class Bridge {
    public static void main(String[] args) {
        Implementor im = new ConcreteImplementor();
        Abstraction ab = new RefinedAbstraction();
        ab.setImplementor(im);
        ab.Operation();
    }
}

interface Implementor{//实现化角色
    void show();
}
class ConcreteImplementor implements Implementor{//具体实现化
    @Override
    public void show() {
        System.out.println("具体化实现角色被调用");
    }
}
abstract class Abstraction{//抽象化角色
    protected Implementor implementor;//持有实现化角色
    public void setImplementor(Implementor implementor){this.implementor=implementor;}

    abstract void Operation();
}
class RefinedAbstraction extends Abstraction{//扩展抽象化对象
    @Override
    void Operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        super.implementor.show();
    }
}
/**
 * 场景：女士皮包有很多种，可以按用途分、按皮质分、按品牌分、按颜色分、按大小分等，存在多个维度的变化，所以采用桥接模式来实现女士皮包的选购比较合适。
 * */