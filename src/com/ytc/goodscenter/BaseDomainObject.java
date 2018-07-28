/******************************************************************************
 * Copyright (C) 2015 ShenZhen Oneplus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.goodscenter;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public abstract class BaseDomainObject<Key> {

    private Integer id;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public abstract Key identifier();


    @Override
    public boolean equals(Object obj){
        //判断自反性
        if(this == obj){
            return true;
        }
        //判空
        if(obj == null){
            return false;
        }
        //判断类型
        if(obj.getClass() != this.getClass()){
            return false;
        }
        //判断主键
        return BaseDomainObject.class.cast(obj).identifier().equals(this.identifier());
    }

    @Override
    public int hashCode(){
        if(identifier() == null){
            return 0;
        }else{
            return identifier().hashCode();
        }
    }

    public static <Key, Value extends BaseDomainObject<Key>> Collection<Key> findLostIds(Collection<Key> schedule, Collection<Value> found) {
        if (found == null || found.isEmpty()) {
            return schedule;
        }
        List<Key> founds = Lists.newArrayList((Iterators.transform(found.iterator(), new Function<Value, Key>() {
            @Override
            public Key apply(Value input) {
                return input.identifier();
            }
        })));

        List<Key> unfound = new ArrayList<>(schedule);
        if (!unfound.removeAll(founds)) {
            return null;
        }
        return filterNullId(unfound);
    }

    public static <Value> List<Value> filterNullObject(Collection<Value> found) {
        if (found == null || found.isEmpty()) {
            return Lists.newArrayList();
        }
        List<Value> founds = Lists.newArrayList(Iterators.filter(found.iterator(), new Predicate<Value>() {
            @Override
            public boolean apply(Value input) {
                return !(input == null || (input instanceof BaseDomainObject && ((BaseDomainObject) input).isNullObject()));
            }
        }));

        return founds;
    }

    public static <Key, Value> ArrayListMultimap<Key, Value> filterNullObject(ArrayListMultimap<Key, Value> found) {
        if (found == null || found.isEmpty()) {
            return found;
        }
        Map<Key, Value> nullMap = new HashMap<>();
        for(Key key : found.keySet()){
            if(found.get(key).isEmpty()){
                continue;
            }
            for(Value value : found.get(key)){
                if(value == null || value instanceof BaseDomainObject && ((BaseDomainObject<Key>)value).isNullObject()){   //&& value instanceof BaseDomainObject
                    nullMap.put(key, value);
                }
            }
        }
        for(Key key : nullMap.keySet()){
            found.remove(key, nullMap.get(key));
        }
        return found;
    }


    /**
     * 过滤空串ID
     * @param lostIds
     * @param <Key>
     * @return
     */
    public static <Key> Collection<Key> filterNullId(Collection<Key> lostIds){
        if(lostIds==null || lostIds.size()<=0){
            return lostIds;
        }
        return Lists.newArrayList(FluentIterable.from(lostIds).filter(new Predicate<Key>() {
            @Override
            public boolean apply(Key input) {
                return input!=null&&StringUtils.isNotEmpty(String.valueOf(input));
            }
        }));
    }

    public Boolean isNullObject(){
        return id != null && id < 0;
    }

    public void setNullObject(){
        id = -1;
    }
}
