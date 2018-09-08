package com.ytc.multithread;

public class TestSync2 implements Runnable {
    int b = 100;          

    synchronized void m1() throws InterruptedException {
        b = 1000;
        Thread.sleep(500); //6
        System.out.println("b=" + b);
    }

    synchronized void m2() throws InterruptedException {
        Thread.sleep(250); //5
        b = 2000;
    }

    /**
     * 1.如果主线程先被调度，执行m2()，b=2000 ; 执行完后主线程继续，打印main thread b=2000;执行子线程，打印b=1000
     * 2.如果主线程先被调度，执行m2()，b=2000 ; 执行完毕后，子线程获取到锁：
     *    2.1子线程得到cpu调度，执行b=1000; 睡眠，释放cpu， 然后主线程获取cpu打印main thread b=1000?
     *                                                  或者 主线程打印b=2000(因为子线程改变状态变量b的值，可能对主线程不可见)，然后子线程打印b=1000
     *    2.2主线程得到cpu调度（此时主线不需要获取锁），打印main thread b=2000 ,子线程继续执行b=1000,子线程打印b=1000
     * 3.如果子线程先被调度，执行m1(),打印b=1000; 主线程被调度，打印main thread b=2000
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        TestSync2 tt = new TestSync2();
        Thread t = new Thread(tt);  //1
        t.start(); //2
        tt.m2(); //3
        System.out.println("main thread b=" + tt.b); //4
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 1.
//    main thread b=2000
//    b=1000

// 2.1
//    main thread b=1000
//    b=1000
//    或者
//    main thread b=2000
//    b=1000
//

// 2.2
//    main thread b=2000
//    b=1000

// 3.
//    b=1000
//    main thread b=2000