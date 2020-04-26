package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>CountOneNumber</code>
 * @description: 计算整数的按照1的存储个数
 * @create: 2020/4/26 12:43
 * @author: dongboye
 */
public class CountOneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N > 0 && N < Integer.MAX_VALUE){
            int total = 0;
            while(N > 0){
                if(N % 2 == 1){
                    ++total;
                }
                N = N / 2;
            }
            System.out.println(total);
        }
    }
}
