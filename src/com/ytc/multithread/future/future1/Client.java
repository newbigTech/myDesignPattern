/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.future.future1;

/**
 * @author yutianci
 * @version V1.0
 * @Title: Client.java
 * @Package com.ytc.multithread.future
 * @Description
 * @date 2018 09-08 17:52.
 */
public class Client {

    public MyFuture tryLoadData(){
        MyFuture<String> realData = new RealData();
        final MyFuture futureData = new FutureData(realData);

        new Thread(new Runnable() {
            @Override
            public void run() {
                futureData.loadData(10);
            }
        }).start();

//        String data = futureData.getData();
        return futureData;
    }
}
