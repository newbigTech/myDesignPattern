/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.oneplus.common.utils.JSONUtils;
import org.apache.commons.collections4.MultiMap;

import java.util.Collection;
import java.util.Map;

/**
 * @author yutianci
 * @version V1.0
 * @Title: MultiMapTest.java
 * @Package com.ytc.guava
 * @Description
 * @date 2018 08-14 11:30.
 */
public class MultiMapTest {

    public static void main(String[] args) {
//        MultiMap<String, Object> map = new ArrayListMultimap<>();
        Multimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("asdf","qwer");
        multimap.put("asdf","ouus");
        multimap.put("asdf","fegag");
        multimap.put("zcvb","fdfgjr");
        System.out.println(JSONUtils.toJsonStr(multimap));
        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println(JSONUtils.toJsonStr(map));
    }
}
