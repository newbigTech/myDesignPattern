package com.ytc.dp.adapter;

class Test {

    public static void main(String[] arg) {

        ClassLoader c = Test.class.getClassLoader();  //获取Test类的类加载器

        System.out.println(c);

        ClassLoader c1 = c.getParent();  //获取c这个类加载器的父类加载器

        System.out.println(c1);

        ClassLoader c2 = c1.getParent();//获取c1这个类加载器的父类加载器

        System.out.println(c2);

        Test t  = new Test();
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader);

    }

}