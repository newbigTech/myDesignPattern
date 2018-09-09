/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.future.future1;


/**
 * @author yutianci
 * @version V1.0
 * @Title: FutureData.java
 * @Package com.ytc.multithread
 * @Description
 * @date 2018 09-03 12:06.
 */
public class FutureData implements MyFuture<String> {

    private final MyFuture<String> realData;

    private volatile Boolean ready = false;

    public FutureData(MyFuture data){
        this.realData = data;
    }

    @Override
    public String getData() {
        synchronized (realData) {
            while (!ready) {
                try {
                    System.out.println(Thread.currentThread().getName()+"<<<我要被阻塞拉。。。");
                    realData.wait();
                    System.out.println(Thread.currentThread().getName()+">>>被唤醒拉。。");
                    System.out.println(ready);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return realData.getData();
        }
    }

    @Override
    public void loadData(final Integer count) {
        synchronized (realData) {
//            System.out.println("加载内容哈。。。");
            realData.loadData(count);
            ready = true;
            System.out.println(Thread.currentThread().getName()+"....唤醒所有等待的线程");
            realData.notifyAll();
        }
    }

/*    @Override
    public String getData() {
        synchronized (realData) {
            while (!ready) {
                try {
                    realData.wait();
                    System.out.println("被唤醒拉。。");
                    System.out.println(ready);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return realData.getData();
        }
    }

    @Override
    public void loadData(final Integer count) {
        synchronized (realData) {
            final Data data = this;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    realData.loadData(count);
                    ready = true;
                    realData.notifyAll();
                }
            }).start();
        }
    }*/


/*    @Override
    public synchronized String getData() {
        while (!ready) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getData();
    }

    @Override
    public synchronized void loadData(final Integer count) {
        final Data data = this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                realData.loadData(count);
                ready = true;
                data.notifyAll();
            }
        }).start();
    }*/
}
