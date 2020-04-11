package com.boye.concerrency.juc;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class TestAtomic {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable{
    private AtomicInteger serializeNumber = new AtomicInteger();
    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerializeNumber());
    }

    public int getSerializeNumber(){
        return serializeNumber.getAndIncrement();
    }
}