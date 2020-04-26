package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>LastWordLength</code>
 * @description: TODO
 * @create: 2020/4/25 16:53
 * @author: dongboye
 */
public class LastWordLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            System.out.println(arr[arr.length - 1].length());
        }
    }
}
