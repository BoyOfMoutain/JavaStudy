package com.boye.concerrency.juc;

/**
 * 一个MyNumber对象：
 *  1.两个普通同步方法，两个线程，打印？ //one two
 *  2.两个普通同步方法，新增Thread.sleep方法给getOne，打印？ //one two
 *  3.两个普通同步方法，新增普通方法getThree,打印？ //three one two
 *  4.修改getOne为静态方法，两个线程，打印？ //two one
 *  5.修改两个方法都为静态方法，两个线程，打印？  //one two
 *  两个MyNumber对象：
 *  6.两个普通同步方法，两个线程，打印？ //two one
 *  7.一个静态方法，一个非静态方法，两个线程，打印？ //two one
 *  8.两个静态方法，两个线程，打印?   //one two
 *
 * 线程8锁：
 * ①非静态锁的锁默认为this，静态锁默认为对应当前的Class实例。
 * ②在某一个时刻内，只能有一个线程持有锁，无论几个方法。
 */
public class Test8Thread {
    public static void main(String[] args) {
        MyNumber number1 = new MyNumber();
        MyNumber number2 = new MyNumber();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number1.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number2.getTwo();
            }
        }).start();

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                number1.getThree();
            }
        }).start();*/
    }
}

class MyNumber{

    public static synchronized void getOne(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo(){
        System.out.println("two");
    }

    public void getThree(){
        System.out.println("three");
    }
}