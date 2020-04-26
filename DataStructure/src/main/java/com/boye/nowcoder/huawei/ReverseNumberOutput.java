package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>ReverseNumberOutput</code>
 * @description: TODO
 * @create: 2020/4/26 00:47
 * @author: dongboye
 */
public class ReverseNumberOutput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num > 0 && num < Integer.MAX_VALUE){
            while(num > 0){
                int a = num % 10;
                System.out.print(a);
                num /= 10;
            }
        }else{
            new RuntimeException("数字不符合");
        }
    }
}
