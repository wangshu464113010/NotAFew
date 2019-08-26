package com.example.demo.designpattern.dp01_principle.dp06_crp;

/**
 * Created by wangshu on 2019/8/7.
 *
 * 合成复用原则（Composite Reuse Principle，CRP）又叫组合/聚合复用原则（Composition/Aggregate Reuse Principle，CARP）。
 * 它要求在软件复用时，要尽量先使用组合或者聚合等关联关系来实现，其次才考虑使用继承关系来实现。
 * 如果要使用继承关系，则必须严格遵循里氏替换原则。合成复用原则同里氏替换原则相辅相成的，两者都是开闭原则的具体实现规范。
 *
 * 开闭原则是总纲：要对扩展开放，对修改关闭；
 * 里氏替换原则：不要破坏继承体系；
 * 依赖倒置原则：要面向接口编程；
 * 单一职责原则：实现类要职责单一；
 * 接口隔离原则：在设计接口的时候要精简单一；
 * 迪米特法则：要降低耦合度；
 * 合成复用原则：要优先使用组合或者聚合关系复用，少用继承关系复用。
 */
public class CompositeReusePrinciple {
}
class A{
    private B b;//包含，而不是继承
}
class B{
}