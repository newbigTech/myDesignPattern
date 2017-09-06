package com.ytc.profiles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/9/4.
 */
public class TestStr {
    public static void main2(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        final int loopCount = 2000000;
        final CountDownLatch latch = new CountDownLatch(loopCount);
        for (int i = 0; i < loopCount; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello Work" + latch.getCount());
                    latch.countDown();
                }
            });
        }
        latch.await();
    }

    public static void main(String[] args) {

        List<TestStr> list = new ArrayList<>();
        while (true){
            list.add(new TestStr());
        }
    }
    @Test
    public void testPool(){
        String str1 = "abc";
        String str2 = new String("def");  //����غ󣬽�class�ļ��������з�������ת�浽����ʱ�����أ���֤��׼���󣬴�����def�����󣬲������ô浽ȫ���ַ��������ء������׶Σ������������滻��ֱ������
        String str3 = "abc";
        String str4 = str2.intern();
        String str5 = "def";
        System.out.println(str1 == str3);//true
        System.out.println(str2 == str4);//false
        System.out.println(str4 == str5);//true

    }
    @Test
    public void testPool2(){
        /**
         *
         * ������ intern ����ʱ��������Ѿ�����һ�����ڴ� String ������ַ������ö����� equals(Object) ����ȷ�������򷵻س��е��ַ��������򣬽��� String ������ӵ����У����ҷ��ش� String ���������
         *
         * ����jdk1.6������ʱ����õ�����false������jdk1.7�����У���õ�һ��true��һ��false��
         �����Ĳ���������jdk1.6�� intern ��������״��������ַ���ʵ�����Ƶ����ô��������أ��У������ش����ã�����jdk1.7�У�ֻ�ǻ���״��������ַ���ʵ����������ӵ��������У�û�и��ƣ��������ش����á�
         ������jdk1.7��ִ��������룬str1����true����������ָ��Ķ���str1���󣨶��У������в����ڣ�����ԭ���ã�����str2����false����Ϊ�����Ѿ�����"java"�ˣ��ؼ��ʣ������Է��صĳصĶ�����˲���ȡ�
         */
        String str1 = new StringBuilder("chaofan").append("wei").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("tian").append("ci").toString();
        System.out.println(str2.intern() == str2);
        String str3 = "java";
//        String str3 = new StringBuilder("jav").append("a").toString();
        System.out.println(str3.intern() == str3);
    }


    @Test
    public void test3(){

        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));//true
        System.out.println(str5 == str3);//false
        System.out.println(str5.intern() == str3);//true
        System.out.println(str5.intern() == str4);//false


    }
    @Test
    public void test4(){

        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;

        System.out.println(b.intern() == a);//fasle
        System.out.println(b.intern() == c);//true
        System.out.println(b.intern() == d);//true  ������d��ȷ��(�޸ġ���ֵ)Ϊab
        System.out.println(b.intern() == f);//false
        System.out.println(b.intern() == a.intern());//true


    }
    @Test
    public void test5(){
        // ��������ȷ��
        String a = "abc";
        String b = "abc";
        String c = "a" + "b" + "c";
        String d = "a" + "bc";
        String e = "ab" + "c";

        System.out.println(a == b);//true
        System.out.println(a == c);//true
        System.out.println(a == d);//true
        System.out.println(a == e);//true
        System.out.println(c == d);//true
        System.out.println(c == e);//true
    }
}