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
        String str2 = new String("def");  //类加载后，将class文件常量池中符号引用转存到运行时常量池，验证、准备后，创建“def”对象，并将引用存到全局字符串常量池、解析阶段，将符号引用替换成直接引用
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
         * 当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（该对象由 equals(Object) 方法确定），则返回池中的字符串。否则，将此 String 对象添加到池中，并且返回此 String 对象的引用
         *
         * 当在jdk1.6中运行时，会得到两个false，而在jdk1.7中运行，会得到一个true和一个false。
         产生的差异在于在jdk1.6中 intern 方法会把首次遇到的字符串实例复制到永久待（常量池）中，并返回此引用；但在jdk1.7中，只是会把首次遇到的字符串实例的引用添加到常量池中（没有复制），并返回此引用。
         所以在jdk1.7中执行上面代码，str1返回true是引用他们指向的都是str1对象（堆中）（池中不存在，返回原引用），而str2返回false是因为池中已经存在"java"了（关键词），所以返回的池的对象，因此不相等。
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
        System.out.println(b.intern() == d);//true  编译期d已确定(修改、赋值)为ab
        System.out.println(b.intern() == f);//false
        System.out.println(b.intern() == a.intern());//true


    }
    @Test
    public void test5(){
        // 编译期已确定
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