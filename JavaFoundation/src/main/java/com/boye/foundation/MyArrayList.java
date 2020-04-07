package com.boye.foundation;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 手写一个ArrayList
 */
public class MyArrayList<T> {
    /**
     * ArrayList主要就是操作数组,所以首先需要定义一个数组
     */
    private Object[] elementData;

    /**
     * elementData的默认长度
     */
    private int defaultLength = 5;

    /**
     * 默认的元素个数
     */
    private int size;

    public MyArrayList(int defaultLength){
        if (defaultLength <= 0){//对异常情况下进行处理
            defaultLength = this.defaultLength;
        }
        elementData = new Object[defaultLength];
    }

    public MyArrayList(){
        this(5);
    }

    /**
     * 添加一个元素
     * @param t T
     * @return boolean
     */
    public boolean add(T t){
        /**
         * 添加之前必须检查是否需要扩容
         * 这里为什么需要size+1？当size到了5之后就需要扩容了。
         */
        expansion(size + 1);
        /**
         * size:表示元素的索引,当前索引位置更新值之后需要自增一次,下次添加的时候也是如此
         */
        elementData[size++] = t;
        return true;
    }

    /**
     * 扩容方法
     * @param minLength int
     */
    private void expansion(int minLength){
        /**
         * 首先判断目前最小长度是否超过默认长度了
         * 我就不弄很复杂的算法了。直接向右移1个位加上目前的长度
         */
        if(minLength > defaultLength){
            /**
             * 得到新的长度
             */
            defaultLength = minLength + (defaultLength >> 1);
            /**
             * 现在我们需要拷贝一个新的数组出来，可以使用2个方法
             * 1.System.arraycopy
             * 2.Arrays.copyOf：这个方法简单，其实底层也是使用的System.arraycopy方法
             * 拷贝elementData数据的元素到elementData，且为elementData设置一个新长度
             */
            elementData = Arrays.copyOf(elementData, defaultLength);
        }
    }

    /**
     * 所在序列号
     * @param t T
     * @return int
     */
    public int indexOf(T t){
        for (int i = 0; ; i++) {
            if(i == size){//如果集合列表里最后一个了过去了，即没有找到的情况下，就得退出，返回-1
                return -1;
            }
            if(t == null && elementData[i] == null){
                return i;
            }
            /**
             * 注意这里千万不要使用elementData[i].equals(t)
             * 因为elementData是可以储存null值的
             * 判断时会引发java.lang.NullPointerException异常。
             */
            else if(t.equals(elementData[i])){
                return i;
            }

        }
    }

    /**
     * 判断是否包含有
     * @param t T
     * @return boolean
     */
    public boolean contains(T t){
        return indexOf(t) > -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public Object[] toArray(){
        return Arrays.copyOf(elementData, size);
    }

    public T get(int index){
        arrayIndexOutOfBoundsException(index);
        return getElement(index);
    }

    private T getElement(int index){
        return (T) elementData[index];
    }
    /**
     * 数组越界的处理
     * @param index int
     */
    private void arrayIndexOutOfBoundsException(int index){
        if(index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException("数组越界了！");
        }
    }

    //用指定的元素替代此列表中指定位置上的元素
    public void set(int index, T t){
        arrayIndexOutOfBoundsException(index);
        elementData[index] = t;
    }

    /**
     * 移除此列表中指定位置上的元素。
     * 删除玩之后需要--size,并且全部都得移位
     * @param index int
     * @return T
     */
    public T remove(int index){
        arrayIndexOutOfBoundsException(index);
        T t = getElement(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i +1];
        }
        //设置最后一个元素为空,并且size减1
        elementData[--size] = null;
        return t;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    //再写一个迭代器
    public Iterator<T> iterator(){
        /**
         * 创建一个局部内部类，实现Iterator
         */
        class MyIterator implements Iterator<T>{
            /**
             * 数组的索引
             */
            private int index;

            //检查是否有下一个元素
            @Override
            public boolean hasNext() {
                return index < size ? true : false;
            }

            @Override
            public T next() {
                return getElement(this.index++);
            }
        }
        return new MyIterator();
    };
}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.set(2, 88);
        list.add(6);
        list.add(5);
        printList(list);
        System.out.println("size = "+ list.size());
        int r = list.remove(0);
        System.out.println("remove :" + r);
        printArray(list.toArray());
        printListByMyIterator(list);
    }

    private static void printList(MyArrayList<Integer> list){
        System.out.print("打印MyArrayList：");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    private static void printArray(Object[] arr){
        System.out.print("打印Array：");
        for (Object v: arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    private static void printListByMyIterator(MyArrayList<Integer> list){
        System.out.print("打印MyArrayList根据MyIterator：");
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}