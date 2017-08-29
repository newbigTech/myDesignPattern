package com.ytc.dp.simpleFactory;

/**
 * Created by Administrator on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        Product product = ProductFactory.createProduct(2);
        product.showProp();
    }
}
