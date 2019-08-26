package com.example.demo.designpattern.dp02_gof.gof02_structural.s06flyweight;

import java.util.HashMap;

/**
 * Created by wangshu on 2019/8/9.
 *
 * 享元（Flyweight）模式的定义：运用共享技术来有効地支持大量细粒度对象的复用。它通过共享已经存在的又想来大
 * 幅度减少需要创建的对象数量、避免大量相似类的开销，从而提高系统资源的利用率。
 *
 * 享元模式的主要优点是：相同对象只要保存一份，这降低了系统中对象的数量，从而降低了系统中细粒度对象给内存带来的压力。
 * 其主要缺点是：
 *      为了使对象可以共享，需要将一些不能共享的状态外部化，这将增加程序的复杂性。
 *      读取享元模式的外部状态会使得运行时间稍微变长。
 *
 * 享元模式中存在以下两种状态：
 *      内部状态，即不会随着环境的改变而改变的可共享部分；
 *      外部状态，指随环境改变而改变的不可以共享的部分。享元模式的实现要领就是区分应用中的这两种状态，并将外部状态外部化。
 * 享元模式的主要角色有如下。
 *      抽象享元角色（Flyweight）:是所有的具体享元类的基类，为具体享元规范需要实现的公共接口，非享元的外部状态以参数的形式通过方法传入。
 *      具体享元（Concrete Flyweight）角色：实现抽象享元角色中所规定的接口。
 *      非享元（Unsharable Flyweight)角色：是不可以共享的外部状态，它以参数的形式注入具体享元的相关方法中。
 *      享元工厂（Flyweight Factory）角色：负责创建和管理享元角色。当客户对象请求一个享元对象时，享元工厂检査系统中是否存在符合要求的享元对象，
 *                                        如果存在则提供给客户；如果不存在的话，则创建一个新的享元对象。
 */
public interface Flyweight {
    void opertion();
}
class ConcreteFlyweight implements Flyweight{

    private String key;
    public ConcreteFlyweight(String key){
        this.key = key;
    }
    @Override
    public void opertion() {
        System.out.println("具体享元角色");
    }
}
class FlyweightFactory{//享元工厂
    private HashMap<String,Flyweight> f = new HashMap<>();
    public Flyweight getFlyweight(String key){
        Flyweight flyweight = f.get(key);
        if(flyweight == null){
            flyweight = new ConcreteFlyweight(key);
            f.put(key,flyweight);
        }
        return flyweight;
    }
}

