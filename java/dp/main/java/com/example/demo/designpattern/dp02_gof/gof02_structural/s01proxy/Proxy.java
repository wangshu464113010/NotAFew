package com.example.demo.designpattern.dp02_gof.gof02_structural.s01proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wangshu on 2019/8/8.
 * 代理（Proxy）模式的定义：由于某些原因需要给某对象提供一个代理以控制对该对象的访问。这时，访问对象不适合或者不能直接引用目标对象，
 *     代理对象作为访问对象和目标对象之间的中介。
 * 代理模式的主要优点有：
 *     代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
 *     代理对象可以扩展目标对象的功能；
 *     代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度；
 * 其主要缺点是：
 *     在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢；
 *     增加了系统的复杂度；
 *
 * 代理模式的主要角色如下。
 *     抽象主题（Subject）类：通过接口或抽象类声明真实主题和代理对象实现的业务方法。
 *     真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 *     代理（Proxy）类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。
 * 代理模式而分为动态与静态
 * 动态代理可以通过JDK和CGLib实现
 */
public class Proxy {
    public static void main(String[] args) {
        final Subject realSubject = new RealSubject();
        /*System.out.println(realSubject.getClass());
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();
        System.out.println(interfaces[0].getName());*/
        Subject s = (Subject) java.lang.reflect.Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(),
                new InvocationHandler() { //动态代理
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before");
                        method.invoke(realSubject,args);
                        System.out.println("after");
                        return null;
                    }
                });
        s.request();
    }

}
interface Subject{//抽象主题
    void request();
}
class RealSubject implements Subject{//真实主题
    @Override
    public void request() {
        System.out.println("真实主题");
    }
}
class StaticProxy implements Subject{//代理类=====>静态代理
    private Subject subject;
    public void setSubject(Subject subject){this.subject = subject;}
    @Override
    public void request() {//常用于数据库事务开启和回滚，日志记录等
        before();//被代理对象执行之前处理代码
        subject.request();//
        after();//被代理对象执行之后处理代码
    }
    private void before() {
        System.out.println("before");
    }
    private void after() {
        System.out.println("after");
    }
}
class DynamicProxy implements InvocationHandler{//动态代理
    private Subject subject;
    public DynamicProxy(Subject subject) {
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        before();//被代理对象执行之前处理代码
        Object invoke = method.invoke(subject, args);
//        after();//被代理对象执行之后处理代码
        return invoke;
    }
}