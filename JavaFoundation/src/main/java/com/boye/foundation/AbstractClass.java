package com.boye.foundation;

public abstract  class AbstractClass {

    public AbstractClass(){ }

    public static void test2(){
        System.out.println("haha");
    }
    public abstract void test();
}

class ExtendAbstractClass extends AbstractClass{

    public static void main(String[] args) {
        AbstractClass a = new ExtendAbstractClass();//调用抽象类的实现类方法
        a.test();

        AbstractClass b = new AbstractClass() {
            @Override
            public void test() {
                System.out.println("匿名内部类的方法");
            }
        };
        b.test();//调用匿名内部类的方法
    }

    @Override
    public void test() {
        System.out.println("子类对抽象类的方法重载!");
    }
}