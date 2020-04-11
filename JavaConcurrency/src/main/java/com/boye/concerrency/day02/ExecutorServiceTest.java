package com.boye.concerrency.day02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorThread implements Runnable{
    private int num = 0;
    @Override
    public void run() {
        while (true){
            if(num < 100){
                num += 2;
                System.out.println(Thread.currentThread().getName() + ":" + num);
            }else{
                break;
            }
        }
    }
}

class ExecutorThread1 implements Runnable{
    private int num = 1;
    @Override
    public void run() {
        while (true){
            if(num < 100){
                num += 2;
                System.out.println(Thread.currentThread().getName() + ":" + num);
            }else{
                break;
            }
        }
    }
}

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
       // service.submit(t);//适合Callable接口
        service.execute(new ExecutorThread());//适合Runnable接口
        service.execute(new ExecutorThread1());//适合Runnable接口
        service.shutdown();
    }
}
