package com.ytc.dp.abstractFactory.eg2;

/**
 * Created by Administrator on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        IFactory factory = new LowFactory();
        Object product = factory.createProduct(1);
        Computer computer = (Computer) product;
        computer.execute();
    }
}
