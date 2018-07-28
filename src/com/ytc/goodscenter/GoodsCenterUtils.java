/******************************************************************************
 * Copyright (C) 2015 ShenZhen Oneplus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.goodscenter;

import com.google.common.collect.ArrayListMultimap;
import com.oneplus.common.utils.CollectionUtils;
import com.oneplus.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @Title: GoodsCenterUtil
 * @Package com.oneplus.goodscenter.service.core.shared
 * @Description:
 * @version V1.0
 * @author ChenMingjian
 * @date 2016/1/18 18:48
 */
public class GoodsCenterUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger("#GoodsCenterUtils#");
    /**
     * 判断集合是不是修改请求
     */
    public static boolean shouldCollectionModify(Collection<?> collection){
        return collection !=null;
    }

    /**
     * 根据指定分隔符拼接字符串，返回拼接字符串的笛卡尔积
     * @param prefixs
     * @param suffixs
     * @param interval
     * @return
     */
    public static List<String> getCrossJoinStr(Collection<String> prefixs, Collection<String> suffixs, String interval){
        if(CollectionUtils.isEmpty(prefixs) || CollectionUtils.isEmpty(suffixs)){
            return null;
        }
        List<String> crossJoinStrs = new ArrayList<>(prefixs.size() * suffixs.size());
        for(String pix : prefixs){
            for(String six : suffixs){
                if(StringUtils.isEmpty(interval)){
                    crossJoinStrs.add(pix + six);
                }else {
                    crossJoinStrs.add(pix + interval + six);
                }
            }
        }
        return crossJoinStrs;
    }

    /**
     * 更换商品中心图片路径域名
     * @param imageHost
     * @param imageUrl
     * @return
     */
    public static String changeImageHost(String imageHost, String imageUrl){
        if(StringUtils.isEmpty(imageHost) || StringUtils.isEmpty(imageUrl)){
            return null;
        }
        URL url = null;
        try {
            url = new URL(imageUrl);
        } catch (MalformedURLException e) {
            LOGGER.error("change image host error", e);
            return imageUrl;
        }
        return imageHost + url.getPath();
    }

    /**
     * 获取ArrayListMultimap中,不存在values的key值列表
     * @param multimap
     * @param keys
     * @return
     */
    public static List<String> getNullValueByMultimap(ArrayListMultimap<String, String> multimap, List<String> keys){
        if(multimap != null){
            List<String> nullKeys = new ArrayList<>();
            for(String key : keys){
                if(CollectionUtils.isEmpty(multimap.get(key))){
                    nullKeys.add(key);
                }
            }
            if(!CollectionUtils.isEmpty(nullKeys)){
                return nullKeys;
            }
        }
        return null;
    }
}
