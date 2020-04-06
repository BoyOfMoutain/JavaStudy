package com.boye.foundation;

public class StringExample {

    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder("hello world");
        System.out.println(sb1.reverse());
        System.out.println(sb1.charAt(4));
        sb1.delete(0, 5);
        System.out.println(sb1.reverse());
        sb1.insert(2,"-dog-");
        System.out.println(sb1);
        sb1.replace(3,6, "我叫爸爸,呵呵");
        System.out.println(sb1);
        System.out.println(sb1.subSequence(3, 7));
        System.out.println(sb1.substring(3, 7));

        StringBuffer sb2 = new StringBuffer("hello world");
        System.out.println(sb2.reverse());

    }
}
