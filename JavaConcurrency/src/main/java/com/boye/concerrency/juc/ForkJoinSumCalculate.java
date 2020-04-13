package com.boye.concerrency.juc;


import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * ForkJoin
 */

public class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;
    private final static long THURSHOLD = 1000L;

    public ForkJoinSumCalculate(long start, long end){
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THURSHOLD){
            long sum = 0L;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }else{
            long mid =  (end + start) >> 1;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, mid);
            left.fork();//拆分
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(mid +1, end);
            right.fork();//拆分

            return left.join() + right.join();
        }
    }
}

class TestForkJoinPool{

    public static void main(String[] args) {

        //fun();
       // fun1();
        fun2();
    }

    public static void fun(){
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L,  50000000000L);
        Long sum = forkJoinPool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("历时是"+ Duration.between(start, end).toMillis() + "ms");
    }

    public static void fun1(){
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0; i < 50000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("历时是"+ Duration.between(start, end).toMillis() + "ms");
    }

    //java8的并行流计算
    public static void fun2(){
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0L, 50000000000L).parallel().reduce(0, Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("历时是"+ Duration.between(start, end).toMillis() + "ms");
    }


}