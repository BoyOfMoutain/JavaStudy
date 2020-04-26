package com.boye.nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>CountCharNumber</code>
 * @description: TODO
 * @create: 2020/4/25 16:58
 * @author: dongboye
 */
public class CountCharNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] >= 'a' && chars[i] <= 'z'){
                    char C = (char) (chars[i] -32);
                    if (map.get(C) == null){
                        map.put(C, 1);
                    }else{
                        map.put(C, map.get(C)+1);
                    }
                }else{
                    if(map.get(chars[i]) == null){
                        map.put(chars[i], 1);
                    }else{
                        map.put(chars[i], map.get(chars[i])+1);
                    }
                }
            }
            char c = scanner.next().charAt(0);
            if(c >= 'a' && c <= 'z'){
                System.out.println(map.get((char)(c-32)) == null ? 0 : map.get((char)(c-32)));
            }else{
                System.out.println(map.get(c) == null ? 0 : map.get(c));
            }

        }
    }
}
