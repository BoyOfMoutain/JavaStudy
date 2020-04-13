package com.boye.concerrency.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestProductCondition {
    public static void main(String[] args) {
        final MyClerk clerk = new MyClerk();
        new Thread(new MyProducer(clerk), "生产者A").start();
        new Thread(new MyProducer(clerk), "生产者B").start();
        new Thread(new MyConsumer(clerk), "消费者A").start();
        new Thread(new MyConsumer(clerk), "消费者B").start();
    }
}

class MyClerk{
    private int product = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //可以不用synchronized
    public void get(){
        lock.lock();
        try{
            while (product >= 5 ){
                System.out.println("产品已满！");
                try {
                    // wait();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "开始生产:" + ++product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void sale(){
        lock.lock();
        try{
            while(product <= 0){
                System.out.println("产品缺货！");
                try{
                    condition.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "开始消费:" + --product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}

class MyProducer implements Runnable{

    private MyClerk clerk;

    public MyProducer(MyClerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

class MyConsumer implements Runnable{

    private MyClerk clerk;

    public MyConsumer(MyClerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}