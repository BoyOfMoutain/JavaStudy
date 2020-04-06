package com.boye.foundation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* System.out.println("请输入next：");
        String next  =  scanner.next();
        System.out.println("输入的数据为：" + next);*/
        System.out.println("请输入nextLine：");
        String nextLine = scanner.nextLine();
        System.out.println("输入的数据为：" + nextLine);

        String next  =  scanner.next();
        /**
         * 是否有下一条数据输入
         */
        if (scanner.hasNext()) {
            next = scanner.nextLine();
        }
        System.out.println("输入的数据为hasNext：" + next);

        // 从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数hasNextInt：");
        if (scanner.hasNextInt()) {
            // 判断输入的是否是整数
            i = scanner.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数hasNextFloat：");
        if (scanner.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scanner.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        scanner.close();

        List<Integer> list = new ArrayList<>();
    }

}
