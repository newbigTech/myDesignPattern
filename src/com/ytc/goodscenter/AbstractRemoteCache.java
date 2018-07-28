package com.ytc.goodscenter;

import com.google.common.collect.ArrayListMultimap;
import com.oneplus.common.pool2.ResourceCallback;
import com.oneplus.common.redis.JedisTemplate;
import com.oneplus.common.utils.CollectionUtils;
import com.oneplus.common.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by diaozhenyong on 17/3/28.
 */
public abstract class AbstractRemoteCache {
    private static final Logger LOGGER = LoggerFactory.getLogger("#AbstractRemoteCache#");

    public static final int NULL_OBJECT_EXPIRE_SECONDS = 1800;

    @Resource(name = "writeJedisTemplate")
    private JedisTemplate writeJedisTemplate;

    @Resource(name = "readJedisTemplate")
    private JedisTemplate readJedisTemplate;


    public void removeCache(final String prefix, final Collection<String> suffixs) {
        if (suffixs == null || suffixs.isEmpty()) {
            return;
        }
        writeJedisTemplate.execute(new ResourceCallback<Jedis, Boolean>() {
            @Override
            public Boolean doInResource(Jedis jedis) {
                for (String suffix : suffixs) {
                    jedis.del(prefix + suffix);
                }
                return true;
            }
        });
    }

    public <Value> void putCache(final ArrayListMultimap<String, Value> multimapValues, final String prefix) {
        if (multimapValues == null || multimapValues.isEmpty()) {
            return;
        }
        writeJedisTemplate.execute(new ResourceCallback<Jedis, Boolean>() {
            @Override
            public Boolean  doInResource(Jedis jedis) {
                for (String suffix : multimapValues.keys()) {
                    String key = prefix + suffix;
                    //过期时间设置
                    List<Value> value = multimapValues.get(suffix);
                    if( value != null ){
                        jedis.set(key, JSONUtils.toJsonStr(multimapValues.get(suffix)));
                        if(value.size() > 0){
                            Value  firstValue = multimapValues.get(suffix).get(0);
                            if(firstValue == null || (firstValue instanceof BaseDomainObject && ((BaseDomainObject)firstValue) .isNullObject())){
                                jedis.expire(key, NULL_OBJECT_EXPIRE_SECONDS);
                            }
                        }
                    }
                }
                return true;
            }
        });
    }

    protected <Value> ArrayListMultimap<String, Value> getMultimapCache(String prefix, Collection<String> suffixs, Class<Value> clazz) {
        if (suffixs == null || suffixs.isEmpty()) {
            return ArrayListMultimap.create();
        }
        final List<String> keys = GoodsCenterUtils.getCrossJoinStr(Arrays.asList(prefix), suffixs, null);

        List<String> jsonStrs = readJedisTemplate.mget(keys.toArray(new String[keys.size()]));

        ArrayListMultimap<String, Value> resultMultimap = ArrayListMultimap.create();

        for(int i = 0; i < keys.size(); i ++){
            List<Value> values = JSONUtils.toList(jsonStrs.get(i), clazz);
            if(!CollectionUtils.isEmpty(values)){
                resultMultimap.putAll(getCodeByKey(keys.get(i)), values);
            }
        }

        return resultMultimap;
    }

    /**
     * @param values
     * @param <Value>
     */
    public <Value extends BaseDomainObject> void putCache(final Collection<Value> values, final String prefix) {
        if (CollectionUtils.isEmpty(values)) {
            return;
        }
        writeJedisTemplate.execute(new ResourceCallback<Jedis, Boolean>() {
            @Override
            public Boolean doInResource(Jedis jedis) {
                for (Value value : values) {
                    //redis key
                    String key = prefix + value.identifier();
                    if (value.isNullObject()) {
                        jedis.set(key, JSONUtils.toJsonStr(value));
                        jedis.expire(key, NULL_OBJECT_EXPIRE_SECONDS);
                    } else {
                        jedis.set(key, JSONUtils.toJsonStr(value));
                    }
                }
                return true;
            }
        });
    }

    /**
     * 查询缓存
     *
     * @param suffixs
     * @return
     */
    public <Value extends BaseDomainObject> List<Value> getCache(String prefix, Collection<String> suffixs, Class<Value> clazz) {
        if (suffixs == null || suffixs.isEmpty()) {
            return null;
        }
        final List<String> keys = GoodsCenterUtils.getCrossJoinStr(Arrays.asList(prefix), suffixs, null);

        List<String> valueJsonStr = readJedisTemplate.mget(keys.toArray(new String[keys.size()]));
        List<Value> models = GCJsonUtils.toModel(valueJsonStr, clazz);
        return models;
    }

    private String getCodeByKey(String key){
        int lastIndexOf = key.lastIndexOf(":");
        if(lastIndexOf < 0){
            return key;
        }
        return key.substring(lastIndexOf+1);
    }
}
