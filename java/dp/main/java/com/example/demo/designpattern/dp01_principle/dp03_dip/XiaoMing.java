package com.example.demo.designpattern.dp01_principle.dp03_dip;

/**
 * Created by wangshu on 2019/8/7.
 */
//小明
public class XiaoMing implements IReader {
    @Override
    public void read(BookRead bookRead) {
        bookRead.read();
    }
}
