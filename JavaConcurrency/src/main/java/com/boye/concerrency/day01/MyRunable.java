package com.boye.concerrency.day01;


public class MyRunable implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 == 0) {
                System.out.println( Thread.currentThread().getName() + ":" + i);
                if (i == 20){
                    Thread.yield();//让出CPU的执行权
                    System.out.println("我继承的线程让开了CPU的执行权了。。。。");
                }
            }
        }
    }
}

class MyRunableTest {
    public static void main(String[] args) {
        MyRunable r = new MyRunable();
        Thread t = new Thread(r);
        t.setName("我实现的线程");
        t.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 40; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if(i == 16){
                try {
                    t.join();
                    System.out.println("主线程后开始加入我实现的线程。。。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
