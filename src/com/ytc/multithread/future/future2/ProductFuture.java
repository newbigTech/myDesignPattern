/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.future.future2;

/**
 * @author yutianci
 * @version V1.0
 * @Title: ProductFuture.java
 * @Package com.ytc.multithread.future.future2
 * @Description
 * @date 2018 09-09 13:30.
 */
public class ProductFuture<MyProduct> {

    private MyProduct product;

    private boolean ready = false;

    public synchronized MyProduct get() {
        while(!ready) {
            try {
                System.out.println("产品没准备好，future被阻塞");
                this.wait();
                System.out.println("产品ready,future被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    public synchronized void setProduct(MyProduct product) {
        this.product = product;
        ready = true;
        notifyAll();
    }
}
