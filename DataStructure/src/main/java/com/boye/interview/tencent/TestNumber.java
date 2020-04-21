package com.boye.interview.tencent;

public class TestNumber {
    public static void main(String[] args) {
        String a = "2b";
        char[] chars = a.toCharArray();
        int n = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c > '9'){
                n = n * 16 + ( c - 'a' + 10);
            }else{
                n = n * 16 + ( c - '1' + 1);
            }
        }
        System.out.println(n);
    }
}
