package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>SetMyPassword</code>
 * @description: 设置密码
 * @create: 2020/4/27 19:56
 * @author: dongboye
 */
public class SetMyPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                //1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9,
                if (ch >= '0' && ch < '9'){
                    continue;
                }else if(ch == 'a' || ch == 'b' || ch == 'c'){
                    chars[i] = '2';
                }else if(ch == 'd' || ch == 'e' || ch == 'f'){
                    chars[i] = '3';
                }else if(ch == 'g' || ch == 'h' || ch == 'i'){
                    chars[i] = '4';
                }else if(ch == 'j' || ch == 'k' || ch == 'l'){
                    chars[i] = '5';
                }else if(ch == 'm' || ch == 'n' || ch == 'o'){
                    chars[i] = '6';
                }else if(ch == 'p' || ch == 'q' || ch == 'r' || ch == 's'){
                    chars[i] = '7';
                }else if(ch == 't' || ch == 'u' || ch == 'v'){
                    chars[i] = '8';
                }else if(ch == 'w' || ch == 'x' || ch == 'y' || ch == 'z'){
                    chars[i] = '9';
                }else if(ch >= 'A' && ch <= 'Y'){
                    chars[i] = (char) (ch + 33);
                }else if(ch == 'Z'){
                    chars[i] = 'a';
                }
            }
            System.out.println(new String(chars));
        }
    }
}
