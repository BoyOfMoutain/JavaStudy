package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>ReverseWordOutput</code>
 * @description: 单词的逆向输出
 * @create: 2020/4/26 00:58
 * @author: dongboye
 */
public class ReverseWordOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        if(sentence.length() > 0){
            String[] str = sentence.split(" ");
            for (int i = str.length - 1; i >= 0; i--) {
                if(i == 0){
                    System.out.print(str[i]);
                }else{
                    System.out.print(str[i] + " ");
                }
            }
        }
    }
}
