package com.boye.concerrency.day01;
//多人共享一个账户进行存钱的处理

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account{

    private double money;

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
