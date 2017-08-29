package com.ytc.dp.factoryMethod;

/**
 * Created by Administrator on 2017/8/29.
 */
public abstract class Creator {
    public void doSomething(){
        System.out.println("here do something...");
        IProduct p = getProduct();
        p.productMethod();
    }

    public abstract IProduct getProduct();
}
