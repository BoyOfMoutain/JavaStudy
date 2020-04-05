package com.boye.foundation;

/**
 * 注意顺序
 * output:
 * 我是Animal的无参数构造函数
 * 我是dog，汪汪汪。。。。。
 * 我是Animal的无参数构造函数
 * 我是Animal的有参数构造函数，name = 狼
 * 我是dog，汪汪汪。。。。。
 */
public class Animal {

    public void whatAnimal(){
        System.out.println("我是动物，还不清楚具体是什么动物");
    }

    public Animal(){
        System.out.println("我是Animal的无参数构造函数");
    }

    public Animal(String name){
        this();
        System.out.println("我是Animal的有参数构造函数，name = "+ name);
    }
}

class Dog extends Animal{

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.whatAnimal();

        Dog dog2 = new Dog("狼");
        dog2.whatAnimal();
    }

    @Override
    public void whatAnimal(){
        System.out.println("我是dog，汪汪汪。。。。。");
    }

    public Dog(){
        super();
    }

    public Dog(String name){
        super(name); // 调用父类的 有参构造方法
    }
}