package com.example.demo.designpattern.dp02_gof.gof01_creating.c03builder;

/**
 * Created by wangshu on 2019/8/7.
 */
//指挥者Director
public class Director {

    Builder builder = null;
    public Director(Builder builder){
        this.builder = builder;
    }
    public Computer createComputer(String cpu,String mainboard,String ram){
        this.builder.buildCpu(cpu);
        this.builder.buildMainboard(mainboard);
        this.builder.buildRam(ram);
        return this.builder.createComputer();
    }
}
