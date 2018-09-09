/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.future.future2;

import com.ytc.dp.simpleFactory.AProduct;
import com.ytc.dp.simpleFactory.Product;

/**
 * @author yutianci
 * @version V1.0
 * @Title: ProductFactory.java
 * @Package com.ytc.multithread.future.future2
 * @Description
 * @date 2018 09-09 13:29.
 */
public class FutureFactory<T> {

    public static ProductFuture createProduct(final String name) {

        //ProductFuture作为订单
        final ProductFuture future = new ProductFuture<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyProduct myProduct = new MyProduct(name);
                //产品生产完毕后，将订单和产品关联起来
                future.setProduct(myProduct);
            }
        }).start();
        return future;
    }
}
