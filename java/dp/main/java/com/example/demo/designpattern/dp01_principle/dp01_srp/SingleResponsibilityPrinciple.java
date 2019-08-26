package com.example.demo.designpattern.dp01_principle.dp01_srp;

/**
 * Created by wangshu on 2019/8/7.
 *：Liskov Substitution Principle
 * 单一职责原则(Single Responsibility Principle)
 * 单一职责原则（Single Responsibility Principle，SRP）又称单一功能原则，由罗伯特·C.马丁（Robert C. Martin）
 * 于《敏捷软件开发：原则、模式和实践》一书中提出的。这里的职责是指类变化的原因，单一职责原则规定一个类应该有且
 * 仅有一个引起它变化的原因，否则类应该被拆分（There should never be more than one reason for a class to change）。
 *
 * 该原则提出对象不应该承担太多职责，如果一个对象承担了太多的职责，至少存在以下两个缺点：
 *   1.一个职责的变化可能会削弱或者抑制这个类实现其他职责的能力；
 *   2.当客户端需要该对象的某一个职责时，不得不将其他不需要的职责全都包含进来，从而造成冗余代码或代码的浪费。
 * 单一职责原则的核心就是控制类的粒度大小、将对象解耦、提高其内聚性。如果遵循单一职责原则将有以下优点。
 *   1.降低类的复杂度。一个类只负责一项职责，其逻辑肯定要比负责多项职责简单得多。
 *   2.提高类的可读性。复杂性降低，自然其可读性会提高。
 *   3.提高系统的可维护性。可读性提高，那自然更容易维护了。
 *   4.变更引起的风险降低。变更是必然的，如果单一职责原则遵守得好，当修改一个功能时，可以显著降低对其他功能的影响。
 *
 * 接口，方法和类职责单一
 * 目的就是提高代码的可维护性、可读性、扩展性
 */
public class SingleResponsibilityPrinciple {
}
