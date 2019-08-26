package com.example.demo.designpattern.dp02_gof.gof01_creating.c01singleton;

import java.util.ArrayList;

/**
 * Created by wangshu on 2019/8/7.
 *
 * 单例（Singleton）模式的定义：指一个类只有一个实例，且该类能自行创建这个实例的一种模式。
 * 例如，Windows 中只能打开一个任务管理器，这样可以避免因打开多个任务管理器窗口而造成内存资源的浪费，或出现各个窗口显示内容的不一致等错误。
 * 在计算机系统中，还有 Windows 的回收站、操作系统中的文件系统、多线程中的线程池、显卡的驱动程序对象、
 * 打印机的后台处理服务、应用程序的日志对象、数据库的连接池、网站的计数器、Web 应用的配置对象、应用程序中的对话框、系统中的缓存等常常被设计成单例。
 * 单例模式有 3 个特点：
 *  单例类只有一个实例对象；<tt>内存中只有一个该类对象</tt>
 *  该单例对象必须由单例类自行创建；
 *  单例类对外提供一个访问该单例的全局访问点
 ****************************************************************
 * 单例模式的扩展
 * 单例模式可扩展为有限的多例（Multition）模式，这种模式可生成有限个实例并保存在 ArrayList 中，客户需要时可随机获取，
 */
public class Singleton {
}
//单例模式的七中写法(java)
class A{//懒汉式,双重校验加锁
    private static volatile A a = null;//保证 instance 在所有线程中同步
    private A(){}
    public static A getInstance(){//双重校验加锁
        if(a == null){
            synchronized (A.class){
                if(a == null){
                    a = new A();
                }
            }
        }
        return a;
    }
}
class A1{//懒汉式,单线程环境下
    private static A1 a1 = null;
    private A1(){}
    public static A1 getInstance(){
        if(a1 == null){
            a1 = new A1();
        }
        return a1;
    }
}
class A2{//懒汉式，多线程环境下，但效率低
    private static A2 a2 = null;
    private A2(){}
    public synchronized static A2 getInstance(){
        if(a2 == null){
            a2 = new A2();
        }
        return a2;
    }
}
class B{//饿汉式
    private static final B b = new B();
    private B(){}
    public static B getInstance(){
        return b;
    }
}
class B1{//饿汉式
    private static B1 b1 = null;
    static {
        b1 = new B1();
    }
    private B1(){}
    public static B1 getInstance(){
        return b1;
    }
}

class C{//静态内部类
    private C(){}
    private static class Singleton{
        private final static C c = new C();
    }
    public static C getInstance(){
        return Singleton.c;
    }
}
enum D{//枚举，不仅能避免多线程同步问题，防止反射和反序列化重新创建新的对象
    Single;
    public void menthod(){
        //...
    }
}

class Multition{
    private static ArrayList<Multition> list;
    private static int num = 10;
    static {
        list = new ArrayList<>();
        for(int i=0;i<num;++i){
            list.add(new Multition());
        }
    }
    private Multition(){}
    public static Multition getRandomInstance(){return list.get((int)(Math.random()*num));}
//    public static void setNum(int num){Multition.num = num;}//num>0
}

