package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>RemoveLeastTimeLetter</code>
 * @description: 删除字符出现最少的字符
 * @create: 2020/4/27 20:45
 * @author: dongboye
 */
public class RemoveLeastTimeLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            int[] count = new int[26];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                count[ch - 'a'] ++;
                min = Math.min(count[ch - 'a'], min);
            }
            String res = "";
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if(count[ch - 'a'] != min){
                    res += ch + "";
                }
            }
            System.out.println(res);
        }
    }
}
