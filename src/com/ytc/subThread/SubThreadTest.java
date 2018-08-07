/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.subThread;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author yutianci
 * @version V1.0
 * @Title: subThread.java
 * @Package com.ytc
 * @Description
 * @date 2018 08-06 11:49.
 */
public class SubThreadTest {

    public static void main(String[] args) {
        try {
            System.out.println("main runing..."+Thread.currentThread().getName());
            SubThreadTest subThreadTest = new SubThreadTest();
            subThreadTest.myTest2();
            TimeUnit.SECONDS.sleep(50);
            System.out.println("main runing222..."+Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void myTest1(){
        Thread t = new MyThread();
        t.setDaemon(true);
        t.start();
    }
    private void myTest2() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyCallable myCallable = new MyCallable();
        FutureTask<String> ft = new FutureTask(myCallable);
        new Thread(ft).start();
//        Future<String> submit = executorService.submit(myCallable);
//
//        System.out.println();
////        FutureTask<String> ft = new FutureTask<String>(new MyCallable());
////        ft.run();
        String s = ft.get();
        System.out.println(s);
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                for(int i=0;i<20;i++) {
                    System.out.println("MyThread loop"+Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            long currentTime = System.currentTimeMillis();
            System.out.println("myThread runing..."+Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() +"() success: costTime={}ms");
            int i = 5/0;
        }
    }

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            long currentTime = System.currentTimeMillis();
            System.out.println("MyCallable runing..."+Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() +"() success: costTime={}ms");
            int i = 5/0;
            System.out.println("hahhahahah....................");
            return "helloworkd";
        }
    }

}
