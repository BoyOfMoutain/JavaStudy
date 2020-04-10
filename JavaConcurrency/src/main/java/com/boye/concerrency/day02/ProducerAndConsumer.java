package com.boye.concerrency.day02;

class Product{

    private int productNum = 0;

    public synchronized void produce(){
        if(productNum < 10){
            notify();
            productNum ++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productNum +"产品");
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume(){
        if(productNum > 0){
            notify();
            System.out.println(Thread.currentThread().getName() + "开始消费第"+ productNum +"产品");
            productNum --;
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{

    private Product product;

    public Producer(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product.consume();
        }
    }
}
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Product product = new Product();//初始化产品
        Producer p =  new Producer(product);
        p.setName("生产者");
        Consumer c1 = new Consumer(product);
        c1.setName("消费者1");
        Consumer c2 = new Consumer(product);
        c2.setName("消费者2");
        p.start();
        c1.start();
        c2.start();
    }
}
