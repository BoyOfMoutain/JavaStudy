package com.boye.nowcoder.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @project: JavaStudy
 * @classname: <code>SortTwoGroupNumbers</code>
 * @description: 对两组数字进行排序输出
 * @create: 2020/4/25 17:45
 * @author: dongboye
 */
public class SortTwoGroupNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            TreeSet<Integer> set = new TreeSet<>();
            int num = scanner.nextInt();
            if (num > 0){
                for (int i = 0; i < num; i++) {
                    set.add(scanner.nextInt());
                }
            }
            for (Integer n: set) {
                System.out.println(n);
            }
        }

    }
}
