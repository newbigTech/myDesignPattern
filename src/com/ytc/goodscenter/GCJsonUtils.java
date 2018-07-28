package com.ytc.goodscenter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.oneplus.common.utils.CollectionUtils;
import com.oneplus.common.utils.StringUtils;

import java.util.List;

/**
 * Created by diaozhenyong on 17/4/25.
 */
public class GCJsonUtils {

    public static <T extends BaseDomainObject> String toJsonStr(T model) {
        return JSON.toJSONString(model, SerializerFeature.DisableCircularReferenceDetect);
    }

    public static <T extends BaseDomainObject> List<T> toModel(List<String> jsonStr, final Class<T> clazz) {

        if (CollectionUtils.isEmpty(jsonStr)) {
            return null;
        }
        return Lists.newArrayList(FluentIterable.from(jsonStr).filter(new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return !StringUtils.isEmpty(input);
            }
        }).transform(new Function<String, T>() {
            @Override
            public T apply(String input) {
                return JSON.parseObject(input, clazz);
            }
        }));
    }

    public static <T> String toJsonStr(List<T> objects) {
        if (CollectionUtils.isEmpty(objects)) {
            return null;
        }
        return JSON.toJSONString(objects);
    }

    public static <T> List<T> toList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

}
