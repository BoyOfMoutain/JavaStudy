package com.boye.nowcoder.huawei;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>ErrorRecordOutput</code>
 * @description: 错误记录的输出
 * @create: 2020/4/27 17:48
 * @author: dongboye
 */
public class ErrorRecordOutput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while(scanner.hasNext()){
            String filePath = scanner.next();
            int lineNum = scanner.nextInt();
            String[] arr = filePath.split("\\\\");
            String file = arr[arr.length - 1];
            if(file.length() > 16){
                file = file.substring(file.length() - 16);
            }
            String key = file + " " + lineNum;
            if (map.get(key) == null){
                map.put(key, 1);
            }else{
                map.put(key, map.get(key) + 1);
            }
        }
        int count = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            count ++;
            if(count > map.entrySet().size() - 8){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
