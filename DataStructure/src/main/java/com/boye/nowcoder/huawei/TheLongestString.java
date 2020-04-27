package com.boye.nowcoder.huawei;

import java.util.*;

/**
 * @project: JavaStudy
 * @classname: <code>TheLongestString</code>
 * @description: TODO
 * @create: 2020/4/27 22:17
 * @author: dongboye
 */
public class TheLongestString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //k=包含的字符，V=字符的个数
        HashMap<Character, Integer> map = getMap(line);
        //K=字符的连续字符串，V=字符长度
        HashMap<String, MyObject> result = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            char k = entry.getKey();
            String maxStr = getMaxStr(k, map, line);
            MyObject obj = new MyObject(k, maxStr.length(), maxStr);
            result.put(maxStr, obj);
        }
        printLongString(result);
    }

    //打印最长的字符
    private static void printLongString(HashMap<String, MyObject> result){
        List<MyObject> list = new ArrayList<>();
        int maxLength = 0;
        for(Map.Entry<String, MyObject> entry : result.entrySet()){
            MyObject value = entry.getValue();
            maxLength = value.length > maxLength ? value.length : maxLength;
        }
        for(Map.Entry<String, MyObject> entry : result.entrySet()){
            MyObject value = entry.getValue();
            if(value.length == maxLength){
                list.add(value);
            }
        }
        if(list.size() > 0){
            char minChar = list.get(0).key;//设定首位为最小的char
            //K-char，V-maxString
            HashMap<Character, String> targetMap = new HashMap<>();
            targetMap.put(minChar, list.get(0).str);
            for (int i = 1; i < list.size(); i++) {
                MyObject object = list.get(i);
                targetMap.put(object.key, object.str);
                if(minChar > object.key){
                    minChar = object.key;
                }
            }
            System.out.println(targetMap.get(minChar));
        }
    }
    //算出个数
    public static HashMap<Character, Integer> getMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                map.put(chars[i], map.get(chars[i]) + 1);
            }else{
                map.put(chars[i], 1);
            }
        }
        return map;
    }

    public static String getMaxStr(int n, char ch){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
    //获取某个连续字符串
    public static String getMaxStr(char ch, HashMap<Character, Integer> map,  String str){
        String rs = "";
        int maxSize = map.get(ch);
        for(int i = maxSize; i>0; i -- ){
            String maxStr =  getMaxStr(i, ch);
            if(str.contains(maxStr)){
                return maxStr;
            }
        }
        return rs;
    }
}
class MyObject {
    char key;//字符
    Integer length;//字符的长度
    String str;//字符串

    public MyObject(char key, Integer length, String str) {
        this.key = key;
        this.length = length;
        this.str = str;
    }
}
