/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author yutianci
 * @version V1.0
 * @Title: RateLimiterTest.java
 * @Package com.ytc.guava
 * @Description
 * @date 2018 08-10 21:11.
 */
public class RateLimiterTest {

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1, 5, 2};
        RateLimiter rl = RateLimiter.create(0.5);
        for (Integer i : arr) {
            long cur = System.currentTimeMillis();
            rl.acquire(i);
            System.out.println("i="+i+"  cost："+(System.currentTimeMillis()-cur)+" ms");
        }
    }
}
