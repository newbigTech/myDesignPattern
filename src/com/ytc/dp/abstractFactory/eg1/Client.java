package com.ytc.dp.abstractFactory.eg1;

/**
 * Created by Administrator on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        IFactory factory = new LowFactory();
//        IFactory factory = new HighFactory();
        ICPU cpu = factory.createCPU();
        IHardware hardware = factory.createHardware();
        Computer computer = new Computer(cpu,hardware);
        computer.execute();
    }
}
