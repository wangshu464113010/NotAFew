package com.example.demo.designpattern.dp02_gof.gof01_creating.c03builder;

/**
 * Created by wangshu on 2019/8/7.
 *
 */
//建造者实现类ComputerBuilder
public class ComputerBuilder implements Builder{
    private Computer computer = new Computer();
    @Override
    public void buildCpu(String CPU) {
        computer.setMyCPU(CPU);
    }

    @Override
    public void buildMainboard(String mainboard) {
        computer.setmMainboard(mainboard);
    }

    @Override
    public void buildRam(String ram) {
        computer.setmRam(ram);
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}
