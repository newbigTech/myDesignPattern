/******************************************************************************
 * Copyright (C) 2013 - 2018 ShenZhen OnePlus Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳万普拉斯科技有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.ytc.multithread.future.future1;

/**
 * @author yutianci
 * @version V1.0
 * @Title: TestClient.java
 * @Package com.ytc.multithread.future
 * @Description
 * @date 2018 09-08 17:54.
 */
public class TestClient {

    public static void main(String[] args) {
        testFuture1();
//        testFuture2();
    }

    private static void testFuture1(){
        Client client = new Client();
        System.out.println("helooowlllll");
        MyFuture<String> data = client.tryLoadData();
        System.out.println("asdfasdf222");
        String ret = data.getData();
        System.out.println("qwerqwer222");
        System.out.println(ret);
    }


    private static void testFuture2(){
        Client client = new Client();
        MyFuture<String> data = client.tryLoadData();
        String ret = data.getData();
        System.out.println(ret);
    }
}
