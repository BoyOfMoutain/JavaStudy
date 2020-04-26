package com.boye.foundation.test;

import com.boye.foundation.Account;
import com.boye.foundation.Student;
import org.junit.Test;

import java.io.*;

public class ObjectStreamTest {

    //序列化写到磁盘文件里， 序列化
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/object.dat"));
            oos.writeObject(new Student("董存瑞",  "男", 28, new Account(100)));//注意，在把对象流保存在磁盘或者进行网络传输的时候，必须要对写入的对象进行实现序列化Serializable的接口
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //从磁盘文件里读出来， 反序列化
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream( new FileInputStream("src/object.dat"));
            Student student = (Student) ois.readObject();
            System.out.println(student.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
         if(ois!=null){
             try {
                 ois.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
        }

    }

}
