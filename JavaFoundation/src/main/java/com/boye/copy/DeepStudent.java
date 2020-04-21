package com.boye.copy;

public class DeepStudent implements Cloneable {
    //引用类型
    private DeepSubject deepSubject;
    //基础数据类型
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DeepSubject getDeepSubject() {
        return deepSubject;
    }

    public void setDeepSubject(DeepSubject deepSubject) {
        this.deepSubject = deepSubject;
    }

    //重写clone()方法
    @Override
    protected Object clone() {
        //深拷贝
        try {
            // 直接调用父类的clone()方法
            DeepStudent student = (DeepStudent) super.clone();
            student.deepSubject = (DeepSubject) deepSubject.clone();
            return student;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "DeepStudent{DeepStudent: " + this.hashCode() + ",DeepSubject=" + deepSubject + ", name='" + name + "'" + ", age=" + age + '}';
    }
}