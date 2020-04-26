package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>FillEightByte</code>
 * @description: 填充为8位
 * @create: 2020/4/25 18:02
 * @author: dongboye
 */
public class FillEightByte {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            solution(line);
        }
    }

    public static void solution(String line){
        //必须放前面处理
        while(line.length() >= 8){
            System.out.println(line.substring(0, 8));
            line = line.substring(8);
        }
        if(line.length() > 0 && line.length() < 8){//补0
            line = line + "0000000";
            System.out.println(line.substring(0, 8));
        }
    }
}
