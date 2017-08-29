package com.ytc.dp.factoryMethod;

/**
 * Created by Administrator on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator1();
        creator.doSomething();
    }


}
