/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author yutianci
 * @version V1.0
 * @Title: CountDownLatchTest.java
 * @Package com.ytc.multithread.CountDownLatchTest
 * @Description
 * @date 2018 09-09 18:25.
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
       int count = 5;
       final CountDownLatch cdl1 = new CountDownLatch(count);
       final CountDownLatch cdl2 = new CountDownLatch(1);

       for(int i= 0;i<count;i++) {
           new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       cdl2.await();
                       System.out.println(Thread.currentThread().getName()+" executing");
                       TimeUnit.SECONDS.sleep(3);
                       cdl1.countDown();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }).start();
       }

       Long startTime = System.currentTimeMillis();
       cdl2.countDown();
       cdl1.await();
       Long endTime = System.currentTimeMillis();
       System.out.println("time elapses:"+(endTime-startTime));


    }
}
