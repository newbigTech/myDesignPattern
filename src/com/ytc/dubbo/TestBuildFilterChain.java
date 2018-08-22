/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yutianci
 * @version V1.0
 * @Title: TestBuildFilterChain.java
 * @Package com.ytc.dubbo
 * @Description
 * @date 2018 08-18 12:38.
 */
public class TestBuildFilterChain {


    /**
     * 没有Filter
     * 只有一个Filter
     * 有N多Filter
     * @param invoker
     * @param key
     * @param group
     * @param <T>
     * @return
     */
    public static <T> com.alibaba.dubbo.rpc.Invoker<T> buildInvokerChain(List<Filter> filterList, final Invoker<T> invoker, String key, String group){
        Invoker ret = invoker;

        for (final Filter filter : filterList) {
            final Invoker deInvoker = ret;
            ret = new Invoker(){
                @Override
                public Result invoke(Invocation invocation) throws RpcException {
                    return filter.invoke(deInvoker,invocation);
                }

                @Override
                public URL getUrl() {
                    return null;
                }

                @Override
                public boolean isAvailable() {
                    return false;
                }

                @Override
                public void destroy() {

                }

                @Override
                public Class getInterface() {
                    return null;
                }
            };
        }

        return ret;
    }

}
