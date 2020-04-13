package com.boye.concerrency.juc;

/**
 * 注意假唤醒
 */
public class TestProductorAndConsumer {

    public static void main(String[] args) {
        final Clerk clerk = new Clerk();
        new Thread(new Producer(clerk), "生产者A").start();
        new Thread(new Producer(clerk), "生产者B").start();
        new Thread(new Consumer(clerk), "消费者A").start();
        new Thread(new Consumer(clerk), "消费者B").start();
    }
}

//店员类
class Clerk{
    private int product = 0;

    //进货
    public synchronized void get(){
        while (product >= 4 ){
            System.out.println("产品已满！");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "开始生产:" + ++product);
        notifyAll();
    }

    //卖货
    public synchronized void sale(){
        while(product <= 0){
            System.out.println("产品缺货！");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "开始消费:" + --product);
        notifyAll();
    }
}
//生产类
class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

//消费类
class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}