package com.boye.nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>CountTheCharater</code>
 * @description: 统计ascii码
 * @create: 2020/4/26 00:38
 * @author: dongboye
 */
public class CountTheCharater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        if(chars.length > 0){
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if(c >= 0 && c <= 127){
                    if (map.get(c) == null){
                        map.put(c, 1);
                    }else{
                        map.put(c, map.get(c) + 1);
                    }
                }
            }
            System.out.println(map.size());
        }
    }
}
