package com.boye.foundation;

import java.util.Iterator;
import java.util.Objects;

/**
 * 单向的双链表，一个节点指向表头，一个节点指向表位
 * @param <T>
 */
public class MyLinkedList<T> {
    private int size;
    private Node<T> head;//头节点
    private Node<T> tail;//尾节点
    private class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;
        private Node(T t){
            this.data = t;
        }

        private Node<T> get(int index, int tempIndex){
            if(index == tempIndex){
                return this;
            }
            return next.get(index, ++tempIndex);//next循环下一个节点
        }

        private int index(T t, int index){
            if(t == data){
                return index;
            }else if(Objects.isNull(next)){
                return -1;
            }else{
                return index(t, ++index);
            }
        }

        private int lastIndex(T t, int index){
            if(t == data){
                return index;
            }else if(Objects.isNull(prev) || index < 1){
                return -1;
            }else{
                return lastIndex(t, --index);
            }
        }
    }

    private void ArrayIndexOutOfBoundsException(int index){
        if(index >= size || index < 0 || size == 0 ){
            throw new ArrayIndexOutOfBoundsException("下标越界！");
        }
    }

    public int size(){
        return size;
    }

    public T get(int index){
        ArrayIndexOutOfBoundsException(index);
        Node<T> node = head.get(index, 0);
        return node.data;
    }

    //向链表末尾添加一个新节点
    public boolean add(T t){
        final Node<T> newNode = new Node<>(t);
        if(head == null){//第一次插入,让head和tail都指向新增的节点
            head = newNode;
            tail = head;
        }else{
            Node<T> p = tail;
            tail = newNode;
            tail.prev = p;
            p.next = tail;
        }
        ++size;
        return true;
    }

    public void addFirst(T t){
        final Node<T> newNode = new Node<>(t);
        if(head == null){
            head = newNode;
            tail = head;
        }else{
            Node<T> p = head;
            head = newNode;
            head.next = p;
            p.prev = head;
            if(tail == null){
                tail = head;
            }
        }
        ++size;
    }

    public void addByIndex(int index, T t){
        ArrayIndexOutOfBoundsException(index);
        final Node<T> newNode = new Node<>(t);
        Node<T> old = head.get(index, 0);//查找出需要插入的节点位置，被插入后，往后移
        if(old.prev != null){//不是表头
            newNode.prev = old.prev;
            newNode.prev.next = newNode;
        }
        old.prev = newNode;
        newNode.next = old;
        ++size;
    }

    //向链表表尾添加一个新节点
    public void addLast(T t){
        final Node<T> newNode = new Node<>(t);
        Node<T> p = tail;
        tail = newNode;
        tail.prev = p;
        p.next = tail;
        ++size;
    }

    //删除第一个节点并返回这个节点中的对象
    public T removeFirst(){
        if(head == null){
            return null;
        }
        Node<T> p = head;
        if(head.next != null){
            head = p.next;
            head.prev = null;
        }
        --size;
        return p.data;
    }

    //删除最后一个节点并返回这个节点中的对象
    public T removeLast(){
        if(tail == null){
            return null;
        }
        Node<T> p = tail;
        if(tail.prev != null){
            tail = p.prev;
            tail.next = null;
        }
        --size;
        return p.data;
    }

    //删除指定位置的节点
    public T removeByIndex(int index){
        ArrayIndexOutOfBoundsException(index);
        Node<T> p = head.get(index, 0);
        if (p.prev != null && p.next != null ){//删中间节点
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }else if(p.next == null && p.prev != null){//删尾节点
            tail = p.prev;
            tail.next = null;
        }else if(p.prev == null && p.next != null){//删头节点
            head = p.next;
            head.prev = null;
        }
        --size;
        return p.data;
    }

    //得到链表第一个节点的对象
    public T getFirst(){
        if(Objects.isNull(head)){
            throw new NullPointerException("空指针异常，因为容器里还没有任何元素!");
        }
        return head.data;
    }

    //得到链表最后一个节点的对象
    public T getLast(){
        if(Objects.isNull(tail)){
            throw new NullPointerException("空指针异常，因为容器里还没有任何元素!");
        }
        return tail.data;
    }

    public int indexOf(T t){
        if(Objects.isNull(head)){//如果是空链表的话，从前往后找
            return -1;
        }
        return head.index(t, 0);
    }

    public int lastIndexOf(T t){
        if(Objects.isNull(tail)){//如果是空链表的话，从后往前找
            return -1;
        }
        return tail.lastIndex(t, --size);
    }

    //将当前链表index位置节点中的对象替换成参数t指定的对象，返回被替换对象
    public T set(int index, T t){
        Node<T> p = head.get(index, 0);
        T temp = p.data;
        p.data = t;
        return temp;
    }

    //判断链表节点对象中是否含有element
    public boolean contains(T t){
        return indexOf(t) != -1;
    }

    //迭代器
    public Iterator<T> iterator(){
        //匿名类
        return new Iterator<T>(){
            private int index;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
    }
}

class MyLinkedListTest{
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.set(2, 88);
        list.add(6);
        list.add(5);
        printList(list);
        System.out.println("size = "+ list.size());
        int r = list.removeByIndex(0);
        System.out.println("remove :" + r);
      //  printList(list);
        printListByMyIterator(list);
    }

    private static void printList(MyLinkedList<Integer> list){
        System.out.print("打印MyLinkedList：");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    private static void printListByMyIterator(MyLinkedList<Integer> list){
        System.out.print("打印MyLinkedList根据Iterator：");
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
