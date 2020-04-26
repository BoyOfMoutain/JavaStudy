package com.boye.foundation;

import java.io.Serializable;

/**
 * static 和 transient这两个字段修饰后不能被序列化
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 8722717866511568636L;
    private static String name;
    private transient String sex;
    private int age;
    private Account account;


    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Student(String name, String sex, int age, Account account) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", account=" + account +
                '}';
    }
}