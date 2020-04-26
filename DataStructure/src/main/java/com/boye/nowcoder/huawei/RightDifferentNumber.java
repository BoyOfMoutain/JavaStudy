package com.boye.nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>RightDifferentNumber</code>
 * @description: 数字从右边出来
 * @create: 2020/4/26 00:17
 * @author: dongboye
 */
public class RightDifferentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num > 0 && num < Integer.MAX_VALUE){
            Map<Integer, Integer> map = new HashMap<>();
            int a = 0;
            while(num > 0){
                a  = num % 10;
                if(map.get(a) == null ){
                    map.put(a, 1);
                    System.out.print(a);
                }
                num = num / 10;
            }
        }else{
            new RuntimeException("数字超标了");
        }
    }
}
