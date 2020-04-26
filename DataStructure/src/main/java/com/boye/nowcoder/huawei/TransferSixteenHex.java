package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>TransferSixteenHex</code>
 * @description: 16进制的转换，转成10进制
 * @create: 2020/4/25 18:18
 * @author: dongboye
 */
public class TransferSixteenHex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            if(line.length() > 2){
                String numStr = line.substring(2);
                printTenHex(numStr);
            }
        }
    }

    public static void printTenHex(String numStr){
        char[] chars = numStr.toCharArray();
        int sum = 0;

        for (int i = 0; i < chars.length; i++) {
            char C = chars[i];
            if(C >= 'A'  && C <= 'Z'){
                sum = sum * 16 + (C - 'A') + 10;
            }else if(C >= 'a' && C <= 'z'){
                sum = sum * 16 + (C - 'a') + 10;
            }else{
                sum = sum * 16 + (C - '1') + 1;
            }
        }
        System.out.println(sum);
    }
}
