package com.ytc.dp.adapter;

class Test {

    public static void main(String[] arg) {

        ClassLoader c = Test.class.getClassLoader();  //��ȡTest����������

        System.out.println(c);

        ClassLoader c1 = c.getParent();  //��ȡc�����������ĸ��������

        System.out.println(c1);

        ClassLoader c2 = c1.getParent();//��ȡc1�����������ĸ��������

        System.out.println(c2);

        Test t  = new Test();
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader);

    }

}