package com.ytc.dp.simpleFactory;

/**
 * Created by Administrator on 2017/8/29.
 */
public class ProductFactory {

    public static Product createProduct(int type) {
        if (type==1) {
            return new AProduct();
        } else if(type==2) {
            return new BProduct();
        }
        return null;
    }
}
