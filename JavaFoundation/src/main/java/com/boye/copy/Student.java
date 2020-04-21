package com.boye.copy;

public class Student implements Cloneable{
    //引用类型
    private Subject subject;
    //基础数据类型
    private String name;
    private int age;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

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

    //重写clone()方法
    @Override
    protected Object clone()  {
        //浅拷贝
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Student{Student: " + this.hashCode() + ",subject=" + subject + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
