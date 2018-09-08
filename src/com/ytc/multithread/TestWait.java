/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @author yutianci
 * @version V1.0
 * @Title: TestWait.java
 * @Package com.ytc.multithread
 * @Description
 * @date 2018 09-08 16:45.
 */
public class TestWait {

    private boolean flag = false;

    public static void main(String[] args) {
        try {
            TestWait tw2 = new TestWait();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            MyRunnable runnable = new MyRunnable(tw2,countDownLatch);
            new Thread(runnable).start();
            synchronized (tw2) {
                countDownLatch.countDown();
                System.out.println("heaaa........");
                tw2.wait();
                System.out.println("bbbbbbb........");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void method2(){
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+" method2...");
            notifyAll();
        }
    }


}

class MyRunnable implements Runnable{
    TestWait tw;
    CountDownLatch latch;
    public MyRunnable(TestWait tw, CountDownLatch latch){
        this.tw = tw;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tw.method2();
        System.out.println(Thread.currentThread().getName()+" sout...");

    }
}
