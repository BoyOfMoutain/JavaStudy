package com.boye.foundation;

import java.util.*;

public class MyHashMap<K, V> {
    private int size;//元素的总个数
    private static final int DEFAULT_LENGTH = 4;//数组默认长度
    //仿造entrySet方法需要定义一个set集合
    private Set<Map.Entry<K,V>> entrySet;

    /**
     * 储存元素的数组
     */
    private Entry<K,V>[] entries;

    /**
     * 仿造 values方法时使用，和仿造entrySet方法原理一样
     * 也是在put方法中直接将value存入即可.
     */
    private Collection<V> list;

    public MyHashMap(){
        this(DEFAULT_LENGTH);
    }

    public MyHashMap(int defaultLength){
        entries = new Entry[defaultLength];
        //这里需要先实例化一个hashset集合
        entrySet = new TreeSet<>();
        list = new ArrayList<>();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *数组下标算法
     */
    private int hash(K key){
        int h;
        if (key == null){
            h = 0;
        }else{
            h = key.hashCode();
        }
        h >>>= 16;
        return h % entries.length;
    }

    public Set<Map.Entry<K,V>> entrySet() {
        return entrySet;
    }

    /**
     * 仿造这个方法也可以使用偷懒的方式了
     */
    public Collection<V> values() {
        //在put的同时就储存了这个时候直接就返回了
        return list;
    }

    //获取值
    public V get(K key){
        int index = hash(key);
        if (Objects.isNull(entries[index])){
            throw new NullPointerException("没有找到数据");
        }
        Entry<K, V> entry = entries[index].get(key);//这个方法得在自定义的类Entry里有
        return entry == null? null : entry.value;
    }

    /**
     * 当需要put的时候，肯定就跟元素挂钩了
     * 那么我们说过hashmap是数组+链表组成的。
     * 现在第一步需要有一个数组了
     * 首先在创建数组之前我们都知道hashmap是键（key）值（value）队的形式储存的
     * 这个时候就需要创建一个储存key和value的类，这里使用内部类
     * @param key K
     * @param value V
     * @return V
     */
    public V put(K key, V value){
        //创建需要添加的元素
        Entry<K, V> entry = new Entry<>(key, value);
        /**
         * 添加元素之前需要有一个数组，那么需要在全局定一个内部类的数组
         * 现在需要使用算法(key.hashcode()%entries.length)算出数据存在那个索引下。
         */
        int index = hash(key);
        /**
         * 判断数组该下标下是否有元素,如果有那么在判断是否key值一致
         * 一致则覆盖，否则就添加
         */
        if(Objects.isNull(entries[index])){//没有数据，可以直接保存
            entries[index] = entry;
            //在put的时候顺带将entry插入到set中
            entrySet.add(entry);
            //仿造values方法，将value值直接储存到list集合中
            list.add(entry.value);
        }else{
            //添加到链表了
            entries[index].put(entry);
        }
        return value;
    }

    public boolean containsKey(K key){
        int index = hash(key);
        return entries[index].get(key) != null;
    }

    public boolean containsValue(V value){
        return list.contains(value);
    }

    public Set<K> keySet(){
        return new AbstractSet<K>(){

            @Override
            public Iterator<K> iterator() {
                return new Iterator<K>(){
                    private Iterator<Map.Entry<K, V>> iterator = entrySet.iterator();
                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public K next() {
                        return iterator.next().getKey();
                    }

                    @Override
                    public void remove() {
                        iterator.remove();
                    }
                };
            }

            @Override
            public int size() {
                return size;
            }
        };
    }

    /**
     * 这是一个成员内部类
     * 储存hashmap元素的key和value
     * 要仿造entrySet方法需要实现 Comparable, Map.Entry<K,V>
     */
    private final class Entry<P extends K, Q extends V> implements Comparable<Entry<P, Q>>, Map.Entry<K, V>{

        private P key;
        private Q value;

        private long hash;//hash码,比较key是否重复使用

        //数组+链表,所以就需要提供下个节点
        private Entry<P, Q> next;

        private Entry(P key, Q value){
            this.key = key;
            this.value = value;
            this.hash = this.key.hashCode();
        }

        //新增一个
        private void put(Entry<P, Q> entry){
            if(Objects.equals(key, entry.key) && hash == entry.hash){
                value = entry.value;//值被同一个key替换
            }else{
                if(Objects.isNull(next)){
                    next = entry;
                    //在put的时候顺带将entry添加到set中
                    MyHashMap.this.entrySet.add(entry);
                    //仿造values方法，将value值直接储存到list集合中
                    MyHashMap.this.list.add(entry.value);
                    size++;
                }else{
                    next.put(entry);
                }
            }
        }

        private Entry<P, Q> get(P key){
            if(Objects.equals(key, this.key)){
                return this;
            }
            //如果当前key不匹配则判断next节点是否为null，如果为null直接返回null
            if(Objects.isNull(next)){
                return null;
            }
            return next.get(key);//循环下去
        }

        @Override
        public int compareTo(Entry<P, Q> o) {
            return (Objects.equals(this.key, o.key) && (this.hash == o.hash) ? 0 : 1);
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            return (this.value = (Q) value);
        }
    }
}

class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("hello1", "world1");
        map.put("hello2", "world2");
        map.put("hello3", "world3");
        map.put("hello4", "world4");
        map.put("hello5", "world5");
        map.put("hello6", "world6");

        Collection<String> entries = map.values();
        Iterator<String> iterator = entries.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + "\t");
        }

        System.out.println();
        System.out.println("containsKey(\"hello1\") : "+ map.containsKey("hello1"));
        System.out.println("containsValue(\"world3\") : " + map.containsValue("world3"));

        System.out.println(map.get("hello1"));
    }
}