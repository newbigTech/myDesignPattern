/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.future.future2;

/**
 * @author yutianci
 * @version V1.0
 * @Title: Client.java
 * @Package com.ytc.multithread.future.future2
 * @Description
 * @date 2018 09-09 13:33.
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("主线程先搞点事情。。。");
        MyFuture<MyProduct> future = FutureFactory.createProduct("hahah");
        System.out.println("使用futureFactory异步生产产品。。。");
//        TimeUnit.SECONDS.sleep(7);
        MyProduct myProduct = future.get();
        System.out.println(myProduct);
        System.out.println("主线程搞完事情啦。。。");
    }
}
