package com.boye.nowcoder.huawei;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @project: JavaStudy
 * @classname: <code>EnsureRightPassword</code>
 * @description: 确保密码的正常
 * @create: 2020/4/27 18:22
 * @author: dongboye
 */
public class EnsureRightPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();

            int[] flag = new int[4];
            if(line.length() > 8){//condition 1
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char ch = chars[i];
                    if(ch >= 'A' && ch <= 'Z'){
                        flag[0] = 1;
                    }else if(ch >= 'a' && ch <= 'z'){
                        flag[1] = 1;
                    }else if(ch >= '0' && ch <= '9'){
                        flag[2] = 1;
                    }else{
                        flag[3] = 1;
                    }
                }
                int f = flag[0] + flag[1] + flag[2] + flag[3];
                if (f >= 3){//condition 2
                    Set<String> set = new HashSet<>();//判断set的size是否为line.length - 2
                    for (int i = 0; i < line.length() - 2; i++) {
                        String key = line.substring(i, i + 3);
                        set.add(key);
                    }
                    if(set.size() == line.length() -2){
                        System.out.println("OK");
                    }else{
                        System.out.println("NG");
                    }
                }else{
                    System.out.println("NG");
                }
            }else{
                System.out.println("NG");
            }
        }
    }
}
