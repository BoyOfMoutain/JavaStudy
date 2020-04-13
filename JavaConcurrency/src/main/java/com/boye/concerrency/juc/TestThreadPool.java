package com.boye.concerrency.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池的使用
 */
public class TestThreadPool {

    public static void main(String[] args) {
        //1、创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            //2、线程池提交线程
            int finalI = i;
            Future<Integer> future = pool.submit(() -> {
                int sum = finalI;
                for (int j = 0; j <= 10; j++) {
                    sum += j;
                }
                return sum;
            });
            list.add(future);
        }

        for (Future<Integer> future: list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }
}
