package com.boye.concerrency.juc;

import static java.lang.Thread.sleep;

/**
 * 1. volitale关键字提供了一个功能，就是被其修饰的变量在被修改后会被强制刷入到主内存中，
 *      其他处理器的缓存由于遵守了缓存一致性原则，会把这个变量的值从主内存中加载到自己的
 * 　　  缓存中，因此在并发编程中保证了变量的可见性。
 * 2.volitale关键字会禁止指令重排，从而来保证有序性
 * 3.volitale关键字不能保证原子性
 */
public class TestVolitale {
    public static void main(String[] args) {
        ThreadDemo td =  new ThreadDemo();
        Thread t = new Thread(td);
        t.setName("线程");
        t.start();

        while(true){
            if(td.isFlag()){
                System.out.println("66666666666666666666666");
                break;
            }
        }
    }
}
class ThreadDemo implements Runnable{

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(Thread.currentThread().getName()+": flag = "+ isFlag());
    }

    public boolean isFlag(){
        return flag;
    }
}
