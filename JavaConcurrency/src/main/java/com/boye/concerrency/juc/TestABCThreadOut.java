package com.boye.concerrency.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启三个线程，这三个线程分别是A、B、C。每个线程将自己在屏幕上打印10遍，并且显示打印的规律是：ABCABCABC。。。。。
 */

public class TestABCThreadOut {
    public static void main(String[] args) {
        AlternateDemo alternateDemo = new AlternateDemo();
        new Thread(() -> {
            for (int i = 1; i <=20 ; i++) {
                alternateDemo.loopA(i);
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 1; i <=20 ; i++) {
                alternateDemo.loopB(i);
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 1; i <=20 ; i++) {
                alternateDemo.loopC(i);

                System.out.println("==============================");
            }
        },"C").start();
    }
}

class AlternateDemo{

    private int flag = 1;//1 = A， 2 = B， 3 = C
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public void loopA(int totalLoop){
        lock.lock();
        try {
            if(flag != 1){
                conditionA.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":打印第" + i +"次" + ", 共循环"+ totalLoop + "次");
            }
            flag = 2;
            conditionB.signal();//唤醒B。
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop){
        lock.lock();
        try {
            if(flag != 2){
                conditionB.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":打印第" + i +"次" + ", 共打印"+ totalLoop + "次");
            }
            flag = 3;
            conditionC.signal();//唤醒C。
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop){
        lock.lock();
        try {
            if(flag != 3){
                conditionC.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":打印第" + i +"次" + ", 共打印"+ totalLoop + "次");
            }
            flag = 1;
            conditionA.signal();//唤醒A。
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}