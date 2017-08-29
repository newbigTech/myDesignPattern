package com.ytc.dp.factoryMethod;

/**
 * Created by Administrator on 2017/8/29.
 */
public class ConcreteCreator1 extends Creator {
    @Override
    public IProduct getProduct() {
        return new ProductA();
    }
}
