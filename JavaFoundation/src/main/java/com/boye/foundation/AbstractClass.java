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
        AbstractClass a = new ExtendAbstractClass();
        a.test();
      //  AbstractClass.test2();
    }

    @Override
    public void test() {
        System.out.println("hello world!");
    }
}