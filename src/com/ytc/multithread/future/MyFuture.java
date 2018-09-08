/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.future;

/**
 * @author yutianci
 * @version V1.0
 * @Title: Data.java
 * @Package com.ytc.multithread
 * @Description
 * @date 2018 09-03 12:05.
 */
public interface MyFuture<T> {

    T getData();

    void loadData(Integer count);
}
