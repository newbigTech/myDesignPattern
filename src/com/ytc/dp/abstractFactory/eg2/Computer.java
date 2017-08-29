package com.ytc.dp.abstractFactory.eg2;

/**
 * Created by Administrator on 2017/8/29.
 */
public class Computer {
    private ICPU cpu;

    private IHardware hardware;

    public ICPU getCpu() {
        return cpu;
    }

    public void setCpu(ICPU cpu) {
        this.cpu = cpu;
    }

    public IHardware getHardware() {
        return hardware;
    }

    public void setHardware(IHardware hardware) {
        this.hardware = hardware;
    }

    public Computer(){

    }

    public Computer(ICPU cpu,IHardware hardware){
        this.cpu = cpu;
        this.hardware = hardware;
    }

    public void execute(){
        System.out.println("计算机正在计算。。。。");
        System.out.println(this.toString());
        this.cpu.caculate();
        this.hardware.save();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", hardware=" + hardware +
                '}';
    }
}
