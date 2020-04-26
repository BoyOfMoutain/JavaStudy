package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>ReverseStringOutput</code>
 * @description: TODO
 * @create: 2020/4/26 00:53
 * @author: dongboye
 */
public class ReverseStringOutput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.length() > 0){
            char[] chars = line.toCharArray();
            for (int i = chars.length -1; i >= 0; i--) {
                System.out.print(chars[i]);
            }
        }
    }
}
