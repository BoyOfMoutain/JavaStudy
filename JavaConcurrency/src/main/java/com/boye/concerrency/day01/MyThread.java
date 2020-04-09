package com.boye.concerrency.day01;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ ":" + i);
                if (i == 20){
                    yield();//让出CPU的执行权
                    System.out.println("我继承的线程让开了CPU的执行权了。。。。");
                }
            }
        }
    }
}
class MyThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("我继承的线程");
        t1.start();
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if(i == 16){
                try {
                    t1.join();
                    System.out.println("主线程后开始加入我继承的线程。。。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
