package com.example.demo.designpattern.dp02_gof.gof02_structural.s02adapter;

/**
 * Created by wangshu on 2019/8/8.
 * 双向适配器
 */
public class TwoAdapter {
    public static void main(String[] args) {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdaptee adaptee=new AdapteeRealize();
        TwoWayTarget target=new TwoWayAdapter(adaptee);
        target.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
        target=new TargetRealize();
        adaptee=new TwoWayAdapter(target);
        adaptee.specificRequest();
    }
}
//目标接口
interface TwoWayTarget {
    public void request();
}
//适配者接口
interface TwoWayAdaptee {
    public void specificRequest();
}
//目标实现
class TargetRealize implements TwoWayTarget {
    public void request() {
        System.out.println("目标代码被调用！");
    }
}
//适配者实现
class AdapteeRealize implements TwoWayAdaptee {
    public void specificRequest(){
        System.out.println("适配者代码被调用！");
    }
}
//双向适配器
class TwoWayAdapter  implements TwoWayTarget,TwoWayAdaptee {
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;
    public TwoWayAdapter(TwoWayTarget target) {
        this.target=target;
    }
    public TwoWayAdapter(TwoWayAdaptee adaptee) {
        this.adaptee=adaptee;
    }
    public void request() {
        adaptee.specificRequest();
    }
    public void specificRequest() {
        target.request();
    }
}
