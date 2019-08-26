package com.example.demo.designpattern.dp01_principle.dp03_dip;

/**
 * Created by wangshu on 2019/8/7.
 */
//由读书人实现
public interface IReader {
    //阅读
    void read(BookRead bookRead);//依赖于BookRead，(依赖抽象，不依赖于具体实现)
}

/*
* public abstract class iReader{//抽象类写法
*
*   public void read(BookRead bookRead){
*       bookRead.read();
*   }
* }
*
* */

