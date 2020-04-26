package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>ReverseCharacter</code>
 * @description: 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * @create: 2020/4/25 15:56
 * @author: dongboye
 */
public class ReverseCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(new StringBuilder(sc.nextLine()).reverse().toString());
        }
    }
}
