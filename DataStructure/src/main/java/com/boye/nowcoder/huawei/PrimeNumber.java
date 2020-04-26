package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>PrimeNumber</code>
 * @description: TODO
 * @create: 2020/4/25 19:41
 * @author: dongboye
 */
public class PrimeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();
        while(num != 1){
            for (int i = 2; i <= num; i++) {
                if(num % i == 0){
                    num = num / i;
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }
}
