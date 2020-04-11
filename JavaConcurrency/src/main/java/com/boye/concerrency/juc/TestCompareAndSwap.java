package com.boye.concerrency.juc;

/**
 * CAS：是英文单词CompareAndSwap的缩写，中文意思是：比较并替换。CAS需要有3个操作数：内存值V，旧的预期值A，要修改的新值B。
 *     当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。整个比较并替换的操作是一个原子操作。
 *    CAS是乐观锁技术，当多个线程尝试使用CAS同时更新同一个变量时，只有其中一个线程能更新变量的值，而其它线程都失败，失败的线程并不会被挂起，而是被告知这次竞争中失败，并可以再次尝试。
 *
 * CAS虽然很高效的解决了原子操作问题，但是CAS仍然存在三大问题。
 * 1.循环时间长开销很大。
 * 2.只能保证一个共享变量的原子操作。
 * 3.ABA问题。　
 *
 * 什么是ABA问题？ABA问题怎么解决？
 * 如果内存地址V初次读取的值是A，并且在准备赋值的时候检查到它的值仍然为A，那我们就能说它的值没有被其他线程改变过了吗？
 * 如果在这段期间它的值曾经被改成了B，后来又被改回为A，那CAS操作就会误认为它从来没有被改变过。这个漏洞称为CAS操作的“ABA”问题.
 * Java并发包为了解决这个问题，提供了一个带有标记的原子引用类“AtomicStampedReference”，它可以通过控制变量值的版本来保证CAS的正确性。
 * 因此，在使用CAS前要考虑清楚“ABA”问题是否会影响程序并发的正确性，如果需要解决ABA问题，改用传统的互斥同步可能会比原子类更高效。
 *
 * 以下Java程序是 CAS的模拟
 *
 */
class CompareAndSwap{
    //内存的值V
    private int value = 0;

    public synchronized int get(){
        return value;
    }

    /**
     * 交换
     * @param expectedValue 旧的预期值A
     * @param newValue 新的要修改值B
     * @return int
     */
    private synchronized  int compareAndSwap(int expectedValue, int newValue){
        if (value == expectedValue){//如果 V == A,就交换
            value = newValue;//V = B
        }
        return value;
    }

    //比较预期值A，是否和交换的值相等（交换的前提是V==A，否则依旧是V，交换了后就是B）
    //简单讲，判断是否已经交换
    public synchronized boolean compareAndSet(int expectedValue, int newValue){
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}

public class TestCompareAndSwap {

    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expectedValue = cas.get();
                boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
                System.out.println("是否交换了值 = " + b);
            }).start();
        }
    }
}
