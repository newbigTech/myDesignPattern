package com.ytc.testStr;

/**
 * Created by Administrator on 2017/9/11.
 */
public class Haha {
    static int x = 0, y = 0;
    static int a = 0, b = 0;
    private static Address address = new Address();

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                x = b;
            }
        });

        Thread other = new Thread(new Runnable() {
            public void run() {
                b = 1;
                y = a;
            }
        });
        one.start();
        other.start();
        one.join();
        other.join();
        while(true){
            System.out.println(" ("+x + ","+y + ")");
            Thread.sleep(100);
        }

    }

    public static Address getAddress() {
        return address;
    }

    public static void setAddress(Address address) {
        Haha.address = address;
    }
}