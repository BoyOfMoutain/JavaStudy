package com.boye.nowcoder.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>CountBottle</code>
 * @description: TODO
 * @create: 2020/4/27 20:26
 * @author: dongboye
 */
public class CountBottle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int t = 0;
            while(n/3 > 0){
                t += n/3;
                n = n/3 + n%3;
                if(n == 2){
                    t = t + 1;
                }
            }
            list.add(t);
        }
        list.forEach(System.out::println);
    }
}
