package com.boye.concerrency.day02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NumberThreadCallable implements Callable<Integer> {

    private int sum = 0;

    @Override
    public Integer call() throws Exception {
        for (int i = 1; i <= 100 ; i++) {
            if(i % 5 == 0){
                Thread.sleep(100);
                sum += i;
                System.out.println(Thread.currentThread().getName()+ ":" + i);
            }
        }
        return sum;
    }
}

class NumberThreadTest {
    public static void main(String[] args) {
        NumberThreadCallable callable = new NumberThreadCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask,"线程一").start();
        try {
            Integer sum = futureTask.get();
            System.out.println("总和为："+ sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
