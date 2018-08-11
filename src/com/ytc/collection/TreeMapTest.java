/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.collection;

import com.oneplus.common.utils.JSONUtils;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author yutianci
 * @version V1.0
 * @Title: TreeMapTest.java
 * @Package com.ytc.collection
 * @Description
 * @date 2018 08-11 11:56.
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String, Object> tm = new TreeMap<>();
        tm.put("aa",1234);
        tm.put("bb",1234);
        tm.put("cc",1234);
        tm.put("cc",3456);

        System.out.println(JSONUtils.toJsonStr(tm));

        SortedMap<String, Object> bb = tm.tailMap("bb");
        System.out.println(JSONUtils.toJsonStr(bb));
        bb.put("dd", 98796);
        bb.put("cc", 66666);
        System.out.println(JSONUtils.toJsonStr(bb));
        System.out.println(JSONUtils.toJsonStr(tm));
        System.out.println(JSONUtils.toJsonStr(bb));

        //tailMap(fromKey)返回key>=fromKey的子Map
        //修改子Map，原来Map也回被修改
    }

}
