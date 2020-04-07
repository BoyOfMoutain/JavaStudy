package com.boye.foundation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.boye.foundation.Student");
        Constructor constructor = clazz.getConstructor();
        Student student = (Student) constructor.newInstance();
        student.setStuId(1008);
        student.setStuName("我爱你，祖国");
        student.setStuNumber("OX-ds-888");
        System.out.println(student);
        System.out.println("-------------------------------------------------");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            System.out.println("字段名称为：" + field.getName() + ",字段的声明类型为：" + field.getGenericType().getTypeName() + "\t");
        }
        System.out.println("-------------------------------------------------");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            //打印所有方法字段
            System.out.println("方法名称为：" + method.getName() + ",方法返回类型为：" + method.getGenericReturnType().getTypeName() + "\t");
        }
    }
}
