package com.boye.concerrency.juc;

import java.util.Random;
import java.util.concurrent.*;

public class TestScheduledThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = service.schedule(() ->{
               int a = new Random().nextInt(100);
                System.out.println(Thread.currentThread().getName() + ":"  + a);
               return a;
            }, 1, TimeUnit.SECONDS);
            System.out.println("future : " + future.get());
        }
        service.shutdown();
    }
}
