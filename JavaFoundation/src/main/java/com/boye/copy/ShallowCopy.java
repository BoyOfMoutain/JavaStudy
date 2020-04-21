package com.boye.copy;

/**
 * 浅拷贝是按位拷贝对象，它会创建一个新对象，这个对象有着原始对象属性值的一份精确拷贝
 *
 * 1) 对于基本数据类型的成员对象，因为基础数据类型是值传递的，所以是直接将属性值赋值给新的对象。基础类型
 *    的拷贝，其中一个对象修改该值，不会影响另外一个。
 * 2) 对于引用类型，比如数组或者类对象，因为引用类型是引用传递，所以浅拷贝只是把内存地址赋值给了成员变量，
 *   它们指向了同一内存空间。改变其中一个，会对另外一个也产生影响.
 */
public class ShallowCopy {
    public static void main(String[] args) {
        Subject subject = new Subject("yuwen");

        Student studentA = new Student();
        studentA.setSubject(subject);
        studentA.setName("Lynn");
        studentA.setAge(20);

        //对象拷贝后没有生成新的对象，二者的对象地址是一样的
      //  Student studentB = studentA;
        //而浅拷贝的对象地址是不一样的
        Student studentB = (Student) studentA.clone();
        studentB.setName("Lily");
        studentB.setAge(18);
        Subject subjectB = studentB.getSubject();

        subjectB.setName("lishi");
        System.out.println("studentA:" + studentA.toString());
        System.out.println("studentB:" + studentB.toString());
    }
}
