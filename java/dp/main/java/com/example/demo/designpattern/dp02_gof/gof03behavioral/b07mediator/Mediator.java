package com.example.demo.designpattern.dp02_gof.gof03behavioral.b07mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshu on 2019/8/16.
 *
 * 中介者（Mediator）模式的定义：定义一个中介对象来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立
 * 地改变它们之间的交互。中介者模式又叫调停模式，它是迪米特法则的典型应用。
 *
 * 中介者模式是一种对象行为型模式，其主要优点如下。
 * 降低了对象之间的耦合性，使得对象易于独立地被复用。
 * 将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。
 *
 * 其主要缺点是：当同事类太多时，中介者的职责将很大，它会变得复杂而庞大，以至于系统难以维护
 *
 *中介者模式包含以下主要角色。
 * 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
 * 具体中介者（ConcreteMediator）角色：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
 * 抽象同事类（Colleague）角色：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
 * 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
 *
 */
public abstract class Mediator {//抽象中介者
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl); //转发
}
class ConcreteMediator extends Mediator{

    private List<Colleague> colleagues = new ArrayList<>();
    @Override
    public void register(Colleague colleague) {
        if(!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }

    @Override
    public void relay(Colleague cl) {
        for(Colleague ob:colleagues) {
            if(!ob.equals(cl)) {
                ((Colleague)ob).receive();
            }
        }
    }
}
abstract class Colleague{//抽象同事类
    protected Mediator mediator;
    public void setMedium(Mediator mediator){
        this.mediator=mediator;
    }
    public abstract void receive();
    public abstract void send();
}
//具体同事类
class ConcreteColleague1 extends Colleague{
    public void receive() {
        System.out.println("具体同事类1收到请求。");
    }
    public void send() {
        System.out.println("具体同事类1发出请求。");
        mediator.relay(this); //请中介者转发
    }
}
//具体同事类
class ConcreteColleague2 extends Colleague
{
    public void receive()
    {
        System.out.println("具体同事类2收到请求。");
    }
    public void send()
    {
        System.out.println("具体同事类2发出请求。");
        mediator.relay(this); //请中介者转发
    }
}

class MediatorPattern {
    public static void main(String[] args) {
        Mediator md=new ConcreteMediator();
        Colleague c1,c2;
        c1=new ConcreteColleague1();
        c2=new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}