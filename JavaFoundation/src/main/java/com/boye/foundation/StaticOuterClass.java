package com.boye.foundation;

/**
 * 静态嵌套类和非静态嵌套类的区别
 * 主要体现在实例化上
 */
public class StaticOuterClass {
    private static String name = "外部类的名字";
    private int age = 99;

    public void display(){
        //方法内部类
        class MethodInner{
            private String innerName = "方法内部类的名字";
            public void display2(){
                System.out.println("方法内部类的方法：name = "+name + ", age = " + StaticOuterClass.this.age);
                System.out.println("方法内部类的方法：innerName = " + innerName);
            }
        }

        MethodInner methodInner = new MethodInner();
        methodInner.display2();
    }
    //静态嵌套类
    static class StaticInner {
        private static String innerName = "静态内部类的名字";
        public void display(){
            System.out.println("静态内部类的方法：name = "+name );
            System.out.println("静态内部类的方法：innerName = " + innerName);
        }
    }

    //成员内部类
    class Inner{
        private String innerName = "成员内部类的名字";
        public void display(){
            System.out.println("成员内部类的方法：name = "+name+", age = "+ StaticOuterClass.this.age);
            System.out.println("成员内部类的方法：innerName = " + innerName);
        }
    }
}
abstract class AbstractAnimal{
    public abstract void sayHi();
}
class TestInnerClass{
    public static void main(String[] args) {

        StaticOuterClass.StaticInner a = new StaticOuterClass.StaticInner();
        a.display();

        StaticOuterClass.Inner b = new StaticOuterClass().new Inner();
        b.display();

        StaticOuterClass c = new StaticOuterClass();
        c.display();

        AbstractAnimal d = new AbstractAnimal() {
            @Override
            public void sayHi() {
                System.out.println("我就是匿名内部类的方法！");
            }
        };
        d.sayHi();
    }
}
