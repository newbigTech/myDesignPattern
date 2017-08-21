package com.ytc.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by Administrator on 2017/8/21.
 */
public class MyContextClassLoad {
    public static void testContextClassLoader() {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = (Driver) iterator.next();
            System.out.println("driver:" + driver.getClass() + ",loader:" + driver.getClass().getClassLoader());
        }
        System.out.println("current thread contextloader:"+Thread.currentThread().getContextClassLoader());
        System.out.println("current loader:" + MyContextClassLoad.class.getClassLoader());
        System.out.println("ServiceLoader loader:" + ServiceLoader.class.getClassLoader());
    }
    public static void main(String []arg){
        testContextClassLoader();
    }
}
