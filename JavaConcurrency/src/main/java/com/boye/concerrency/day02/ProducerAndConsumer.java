package com.boye.concerrency.day02;

class Product{

    private int productNum = 0;

    public synchronized void produce(){
        while(productNum > 5){//大于1，停止生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        productNum ++;
        System.out.println(Thread.currentThread().getName() + "开始生产第" + productNum +"产品");
    }

    public synchronized void consume(){
        while(productNum <= 0){//小于等于0，停止消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        System.out.println(Thread.currentThread().getName() + "开始消费第"+ productNum +"产品");
        productNum --;
    }
}

class Producer extends Thread{

    private Product product;

    public Producer(Product product){
        this.product = product;
    }

    @Override
    public void run() {
       /* for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product.produce();
        }*/
        while(true){
            product.produce();
        }
    }
}

class Consumer extends  Thread{
    private Product product;

    public Consumer(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        /*for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product.consume();
        }*/
        while(true){
            product.consume();
        }
    }
}
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Product product = new Product();//初始化产品
        Producer p1 =  new Producer(product);
        Producer p2 =  new Producer(product);
        p1.setName("生产者A");
        p2.setName("生产者B");
        Consumer c1 = new Consumer(product);
        c1.setName("消费者C");
        Consumer c2 = new Consumer(product);
        c2.setName("消费者D");
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
