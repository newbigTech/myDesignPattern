/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

/**
 * @author yutianci
 * @version V1.0
 * @Title: GuavaLocalCache.java
 * @Package com.ytc.guava
 * @Description
 * @date 2018 09-01 12:35.
 */
public class GuavaLocalCache {

    public static void main(String[] args) {
        LoadingCache<String, String> configs = CacheBuilder.newBuilder()
                .maximumSize(1000) // 设置最大大小
                .expireAfterWrite(10, TimeUnit.MINUTES) // 设置过期时间， 10分钟
                .build(
                        new CacheLoader<String, String>() {
                            // 加载缓存内容
                            @Override
                            public String load(String key) throws Exception {
                                return "";
//                                return getConfigFromDB(key);
                            }
                            public Map<String, String> loadAll() throws Exception {
                                return new HashMap<String, String>();
//                                return loadConfigFromDB();
                            }
                        });

        //CacheLoader.loadAll

        // 获取某个key的值
        String key = "";
        try {
            String s = configs.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 显式的放入缓存
        configs.put(key, value);
        // 个别清除缓存
        configs.invalidate(key);
        // 批量清除缓存
        List<String> keys = new ArrayList<>();
        configs.invalidateAll(keys);
        // 清除所有缓存项
        configs.invalidateAll();
    }
}
