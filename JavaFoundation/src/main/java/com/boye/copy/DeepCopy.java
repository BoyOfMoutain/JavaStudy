package com.boye.copy;

/**
 * (1) 对于基本数据类型的成员对象，因为基础数据类型是值传递的，所以是直接将属性值赋值给新的对象。
 *     基础类型的拷贝，其中一个对象修改该值，不会影响另外一个（和浅拷贝一样）。
 * (2) 对于引用类型，比如数组或者类对象，深拷贝会新建一个对象空间，然后拷贝里面的内容，所以它们
 *     指向了不同的内存空间。改变其中一个，不会对另外一个也产生影响。
 * (3) 对于有多层对象的，每个对象都需要实现 Cloneable 并重写 clone() 方法，进而实现了对象的串行层层拷贝。
 * (4) 深拷贝相比于浅拷贝速度较慢并且花销较大。
 *
 */
public class DeepCopy {
    public static void main(String[] args) {
        DeepSubject subject = new DeepSubject("yuwen");

        DeepStudent studentA = new DeepStudent();
        studentA.setDeepSubject(subject);
        studentA.setName("Lynn");
        studentA.setAge(20);

        //对象拷贝后没有生成新的对象，二者的对象地址是一样的
        //  Student studentB = studentA;
        //而浅拷贝的对象地址是不一样的
        DeepStudent studentB = (DeepStudent) studentA.clone();
        studentB.setName("Lily");
        studentB.setAge(18);
        DeepSubject subjectB = studentB.getDeepSubject();

        subjectB.setName("lishi");
        System.out.println("studentA:" + studentA.toString());
        System.out.println("studentB:" + studentB.toString());
    }
}
