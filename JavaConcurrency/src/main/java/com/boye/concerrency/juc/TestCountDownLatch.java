package com.boye.concerrency.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch：在完成某些运算时，只有其他的线程完全结束后，才让当前运算继续执行
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int threadNum = 5;
        final CountDownLatch latch = new CountDownLatch(threadNum);
        LatchDemo thread = new LatchDemo(latch);
        for (int i = 0; i < threadNum; i++) {
            new Thread(thread).start();
        }
        long end = System.currentTimeMillis();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时："+(end - start) +"ms");
    }
}

class LatchDemo implements Runnable{
    private CountDownLatch latch;
    public LatchDemo(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                for (int i = 0; i < 50000; i++) {
                    if(i % 100 == 0){
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }
    }
}
