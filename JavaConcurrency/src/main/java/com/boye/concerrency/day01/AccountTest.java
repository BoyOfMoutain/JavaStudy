package com.boye.concerrency.day01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//多人共享一个账户进行存钱的处理
/**
 * 1. synchronized可以保证原子性，通过字节码指令monitorenter和monitorexit。
 * 2. synchronized可以保证可见性
 * 3. synchronized关键字保证同一时刻只允许一条线程操作，从而保证了有序性
 */
class Account{

    private double money;

    /*
    * synchronized和RetreenLock锁区别
    * 1、synchronized是java关键字，RetreenLock是个java类
    * 2、synchronized无法获取锁状态，Lock可以判断是否持有锁
    * 3、synchronized会自动释放锁，Lock需要在finally中unlock()手动释放锁
    * 4、使用synchronized，线程1获取锁，线程2只能等待；使用Lock，线程1获取锁，线程2会尝试获取锁，如果获取不到，不会一直等待，可以直接结束。
    * 5、synchronized和Lock都是可重入，可中断的
    * 6、synchronized适合代码量少的同步，Lock适合大量代码同步
    *
    * */
    //加锁
    private Lock lock = new ReentrantLock();

    public Account(double money){
        this.money = money;
    }

    //存钱
    public void deposit(double amt){
        if(amt > 0){
            try{
                lock.lock();
                money += amt;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( Thread.currentThread().getName()+"存钱成功，余额为：" + money);
            }finally {
                lock.unlock();
            }

        }
    }

    //存钱
    public synchronized void deposit2(double amt){
        if(amt > 0){
            money += amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName()+"存钱成功，余额为：" + money);
        }
    }

}
class Customer extends Thread{

    private Account account;

    public Customer(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        Customer c3 = new Customer(account);
        c1.setName("甲");
        c2.setName("乙");
        c3.setName("丙");
        c1.start();
        c2.start();
        c3.start();
    }
}
