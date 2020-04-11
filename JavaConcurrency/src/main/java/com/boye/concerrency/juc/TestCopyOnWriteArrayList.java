package com.boye.concerrency.juc;

import com.boye.concerrency.util.ObjectAddressUtil;
import jdk.internal.misc.Unsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static jdk.internal.misc.Unsafe.getUnsafe;

/***
 * CopyOnWriteArrayList / CopyOnWriteArraySet
 * 注意：如果添加操作多时，效率低，因为每次添加都会进行复制，开销非常大。如果并发迭代多时，可以选用这两个。
 **/
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        final CopyOnWriteArrayListThread t = new CopyOnWriteArrayListThread();
        for (int i = 0; i < 10; i++) {
            new Thread(t).start();
        }
    }
}

class CopyOnWriteArrayListThread implements Runnable{
    //1.放开这个会报ConcurrentModificationException的错误
  //  private static List<String> list = Collections.synchronizedList(new ArrayList<>());
    //2.放开这个就不会报错。但是会不停的复制list，因为添加一个就会复制一个list
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println("list的size = "+list.size()+", 它的下一个元素是"+it.next());
            list.add("DDD");
        }
    }
}
