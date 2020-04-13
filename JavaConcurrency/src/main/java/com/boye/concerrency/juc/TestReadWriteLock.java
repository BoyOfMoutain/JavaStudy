package com.boye.concerrency.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        new Thread(() -> {
            demo.set((int) (Math.random() * 101));
        },"写线程B").start();

        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                demo.get();
            },"读线程A").start();
        }

    }
}

class ReadWriteLockDemo {
    private int num = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    //读数据
    public void get(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始读：" + num);
        }finally {
            lock.readLock().unlock();
        }
    }

    //写数据
    public void set(int num){
        lock.writeLock().lock();
        try{
            System.out.println("-----------------------------");
            System.out.println(Thread.currentThread().getName() + "开始写：");
            this.num = num;
            System.out.println("-----------------------------");
        }finally {
            lock.writeLock().unlock();
        }
    }
}