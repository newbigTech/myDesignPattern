/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.future;


import java.util.concurrent.TimeUnit;

/**
 * @author yutianci
 * @version V1.0
 * @Title: RealData.java
 * @Package com.ytc.multithread
 * @Description
 * @date 2018 09-03 12:06.
 */
public class RealData implements MyFuture<String> {

    private String content;

    @Override
    public String getData() {
        return content;
    }

    @Override
    public void loadData(Integer count) {
        System.out.println("start load data...");
        StringBuilder sb = new StringBuilder("result>>");
        for(int i = 0 ;i<count;i++) {
            sb.append(i);
            try {
                System.out.println("查询表数据"+i);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("data load over...");
        this.content = sb.toString();
    }
}
