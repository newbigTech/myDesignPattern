/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.future.future2;

/**
 * @author yutianci
 * @version V1.0
 * @Title: MyProduct.java
 * @Package com.ytc.multithread.future.future2
 * @Description
 * @date 2018 09-09 13:30.
 */
public class MyProduct {

    public MyProduct(String name){
        System.out.println("开始生成产品。。。"+name);
        for(int i = 0 ;i<6;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生成产品的零件"+i);
        }
        System.out.println("产品生成结束。。。"+name);

    }
}
