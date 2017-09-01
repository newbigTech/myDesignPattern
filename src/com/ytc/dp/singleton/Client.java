package com.ytc.dp.singleton;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * Created by Administrator on 2017/8/29.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("asdfasdf...");
        Singleton.getInstance();
//        Singleton.testSingle();
    }
}
