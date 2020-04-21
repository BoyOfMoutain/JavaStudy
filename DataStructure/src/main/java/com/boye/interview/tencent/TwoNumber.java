package com.boye.interview.tencent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有一个num1+num2=num3，判断其进制，然后根据数字来判断是否为多少进制。
 */
public class TwoNumber {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        String num1 = line.split("\\+")[0].toLowerCase().trim();
        String num2 = line.split("\\+")[1].toLowerCase().split("=")[0].trim();
        String num3 = line.split("\\+")[1].toLowerCase().split("=")[1].trim();
        if(num1.length() > num3.length() || num2.length() > num3.length()){
            throwException("等号左右不正确，请重新再输入");
        }else{
            if((num1.length() == 0 || num1.length() > 5) || (num2.length() == 0 || num2.length() > 5) ){
                throwException("不符合规矩，请重新再输入");
            }
        }
        fun(num1, num2, num3);
        input.close();
    }

    private static void fun(String num1, String num2, String num3){
        int[] dest = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20};
        List<Integer> list = getHex(num1, num2, num3, dest);
        for (Integer it:list) {
            System.out.println(it);
        }
    }

    private static List<Integer> getHex(String num1, String num2, String num3, int[] dest){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < dest.length; i++) {
            if(getHexNumber(num1, dest[i]) > -1 && getHexNumber(num2, dest[i]) > -1 && getHexNumber(num3, dest[i]) > -1){
                if( getHexNumber(num1, dest[i]) + getHexNumber(num2, dest[i]) == getHexNumber(num3, dest[i])){
                    result.add(dest[i]);
                }
            }
        }
        return result;
    }

    //不同进制转为10进制,Java自带的转换
    private static int getHexNumber2(String num, int hex){
        try {
            return Integer.parseInt(num, hex);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    //自己写的转换
    private static int getHexNumber(String num, int hex){
        char[] chars = num.toCharArray();
        int n = 0;
        for (int i = 0; i <chars.length ; i++) {
            char c = chars[i];
            if(c > '9'){
                if (hex < 11){//如果是低于11进制的话
                    return -1;
                }else{
                    n = n * hex + (chars[i] - 'a' + 10) ;
                }
            }else{
                n = n * hex + ( c - '1' + 1);
            }
        }
        return n;
    }


    private static void throwException(String msg){
        try {
            throw new Exception(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
