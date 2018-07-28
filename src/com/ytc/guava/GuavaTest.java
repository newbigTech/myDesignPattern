/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.oneplus.common.utils.JSONUtils;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * @author yutianci
 * @version V1.0
 * @Title: GuavaTest.java
 * @Package com.ytc.guava
 * @Description
 * @date 2018 07-25 11:05.
 */
public class GuavaTest {

    public static void main(String[] args) {
        SkuInfoDTO skuInfoDTO1 = new SkuInfoDTO();
        skuInfoDTO1.setSku("0112341234");
        skuInfoDTO1.setEnglishName("asdf");
        skuInfoDTO1.setName("01阿斯蒂芬");

        SkuInfoDTO skuInfoDTO2 = new SkuInfoDTO();
        skuInfoDTO2.setSku("0212341234");
        skuInfoDTO2.setEnglishName("asdf");
        skuInfoDTO2.setName("02阿斯蒂芬");

        SkuInfoDTO skuInfoDTO3 = new SkuInfoDTO();
        skuInfoDTO3.setSku("0312341234");
        skuInfoDTO3.setEnglishName("asdf");
        skuInfoDTO3.setName("03阿斯蒂芬");

        SkuInfoDTO skuInfoDTO4 = new SkuInfoDTO();
        skuInfoDTO4.setSku("5012341234");
        skuInfoDTO4.setEnglishName("asdf");
        skuInfoDTO4.setName("501阿斯蒂芬");

        ArrayList<SkuInfoDTO> skuInfoDTOS = Lists.newArrayList(skuInfoDTO1, skuInfoDTO2, skuInfoDTO3, skuInfoDTO4);
//        List<SkuInfoDTO> skuInfoDTOSList2 = Arrays.asList(skuInfoDTO1, skuInfoDTO2, skuInfoDTO3, skuInfoDTO4);
        myfilter1(skuInfoDTOS);
        myfilter2(skuInfoDTOS);
        mytransform(skuInfoDTOS);
        mytransform2(skuInfoDTOS);

        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
        ConcurrentMap<Object, Object> objectObjectConcurrentMap = Maps.newConcurrentMap();
        LinkedHashMap<Object, SkuInfoDTO> objectObjectLinkedHashMap = Maps.newLinkedHashMap();
        TreeMap<String,String> comparableObjectTreeMap = Maps.newTreeMap();

        boolean equals = Objects.equals("asdf", "qwer");
        boolean equals2 = Objects.equals(null, null);
        System.out.println(equals);
        System.out.println(equals2);
        System.out.println(null == null);

        String str = "asdfja,awegaqweljf,fealwjgiqwea,fjaiew:f,eagj.fjae,fjael";
        List<String> strings = Splitter.on(":").splitToList(str);
        System.out.println(JSONUtils.toJsonStr(strings));
    }


    private static void myfilter2(ArrayList<SkuInfoDTO> skuInfoDTOS){
        FluentIterable<SkuInfoDTO> filter = FluentIterable.from(skuInfoDTOS).filter(new Predicate<SkuInfoDTO>() {
            @Override
            public boolean apply(SkuInfoDTO input) {
                return !(input.getSku().startsWith("01")||input.getSku().startsWith("501"));
            }
        });
        ArrayList<SkuInfoDTO> skuInfoDTOS2 = Lists.newArrayList(filter);
        System.out.println(JSONUtils.toJsonStr(skuInfoDTOS2));
    }


    private static void myfilter1(ArrayList<SkuInfoDTO> skuInfoDTOS){
        UnmodifiableIterator<SkuInfoDTO> filter = Iterators.filter(skuInfoDTOS.iterator(), new Predicate<SkuInfoDTO>() {
            @Override
            public boolean apply(SkuInfoDTO input) {
                return input.getSku().startsWith("01") || input.getSku().startsWith("501");
            }
        });
        ArrayList<SkuInfoDTO> skuInfoDTOS2 = Lists.newArrayList(filter);
        System.out.println(JSONUtils.toJsonStr(skuInfoDTOS2));
    }

    private static void mytransform(ArrayList<SkuInfoDTO> skuInfoDTOS){
        FluentIterable<String> transform = FluentIterable.from(skuInfoDTOS).transform(new Function<SkuInfoDTO, String>() {
            @Override
            public String apply(SkuInfoDTO input) {
                return input.getSku();
//                if(input.getSku().startsWith("01")) {
//                    return "";
//                }
//                return null;
            }
        });
        ArrayList<String> strings = Lists.newArrayList(transform);
        System.out.println(JSONUtils.toJsonStr(strings));
//        Joiner.on(',').join();
    }
    private static void mytransform2(ArrayList<SkuInfoDTO> skuInfoDTOS){
        FluentIterable<String> transform = FluentIterable.from(skuInfoDTOS).transform(new Function<SkuInfoDTO, String>() {
            @Override
            public String apply(SkuInfoDTO input) {
                return input.getSku();
            }
        });

        ArrayList<String> strings = Lists.newArrayList(transform);
        System.out.println(JSONUtils.toJsonStr(strings));

        String join = Joiner.on(',').join(transform);
        System.out.println(join);
    }

}
