package com.example.demo.designpattern.dp02_gof.gof01_creating.c03builder;

/**
 * Created by wangshu on 2019/8/7.
 * 建造者（Builder）模式的定义：指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，
 * 这样的设计模式被称为建造者模式。它是将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成。它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。
 * 该模式的主要优点如下：
 *   各个具体的建造者相互独立，有利于系统的扩展。
 *   客户端不必知道产品内部组成的细节，便于控制细节风险。
 *
 * 其缺点如下：
 *     产品的组成部分必须相同，这限制了其使用范围。
 *     如果产品的内部变化复杂，该模式会增加很多的建造者类
 * 建造者设计模式的结构
 *     产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个滅部件。
 *     抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 *     具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 *     指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 */
//建造者Builder
public interface Builder {
    void buildCpu(String CPU);
    void buildMainboard(String mainboard);
    void buildRam(String ram);
    Computer createComputer();
}
