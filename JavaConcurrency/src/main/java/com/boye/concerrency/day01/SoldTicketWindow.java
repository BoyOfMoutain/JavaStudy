package com.boye.concerrency.day01;

import static java.lang.Thread.sleep;

//共享锁，可以选择不同的对象：this、static 修饰的object、当前类.class
public class SoldTicketWindow{

    private static Object hello = new Object();

    public synchronized void methodA ( ){//方法锁
        System.out.println("methodA.....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void methodB() {
        synchronized(this) {//对象锁
            System.out.println("methodB.....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodC() {

        synchronized (hello) {//对象锁
            System.out.println("methodC.....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/**
 * 所谓的锁，要体现共享性的对象。对于实现接口的线程。是不需要加static，因为该对象只有一个副本
 */
class SoldTicketWindow1 implements  Runnable{
    private int ticket = 100;
    private Object lock = new Object();//对象锁，注意，可以不用static，实现的是Runnable接口

    @Override
    public synchronized void run() {
        //synchronized(lock)
        //synchronized(lock)
        synchronized(lock){
            while (true){
                if(ticket > 0){
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                    System.out.println(Thread.currentThread().getName() +"(剩余车票):" + ticket);
                }else{
                    break;
                }
            }

        }
    }
}

/**
 * 而线程继承实现的话，创建线程的时候，它里面的对象也随着线程个数而增加。所以为了保证锁的共享性，需要加static修饰
 */
class SoldTicketWindow2 extends Thread{
    private int ticket = 100;
    private static Object lock = new Object();//对象锁，注意，可以不用static，实现的是Runnable接口
    @Override
    public void run() {
        synchronized(SoldTicketWindow2.class){
            while (true){
                if(ticket > 0){
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                    System.out.println(Thread.currentThread().getName() +"(剩余车票):" + ticket);
                }else{
                    break;
                }
            }

        }
    }
}

class SoldTicketWindowTest{
    public static void main(String[] args) {
        //这些方法可以知道方法锁和当前对象锁，以及局部对象锁的快慢
        SoldTicketWindow soldTicketWindow = new SoldTicketWindow();
        new Thread(soldTicketWindow::methodB, "线程二").start();
        new Thread(soldTicketWindow::methodA, "线程一").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                soldTicketWindow.methodC();
            }
        }, "线程三").start();

        //继承Thread和实现Runnable接口的锁,不一样。
        SoldTicketWindow1 soldTicketWindow1 = new SoldTicketWindow1();
        new Thread(soldTicketWindow1,"实现Runnable接口线程1").start();
        new Thread(soldTicketWindow1,"实现Runnable接口线程2").start();

        SoldTicketWindow2 soldTicketWindow2_1 = new SoldTicketWindow2();
        soldTicketWindow2_1.setName("继承Thread线程1");
        soldTicketWindow2_1.start();
        SoldTicketWindow2 soldTicketWindow2_2 = new SoldTicketWindow2();
        soldTicketWindow2_2.setName("继承Thread线程2");
        soldTicketWindow2_2.start();


    }
}