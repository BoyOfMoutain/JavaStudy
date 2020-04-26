package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>UpDownToInteger</code>
 * @description: 四舍五入
 * @create: 2020/4/25 22:52
 * @author: dongboye
 */
public class UpDownToInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float num = scanner.nextFloat();
        int n = (int) (num / 1);
        if(num - n >= 0.5){
            System.out.println(n +1);
        }else{
            System.out.println(n);
        }
    }
}
