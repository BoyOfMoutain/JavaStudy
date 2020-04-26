package com.boye.nowcoder.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @project: JavaStudy
 * @classname: <code>MergeAndSortIndex</code>
 * @description: 对相同索引合并，然后不同的索引排序
 * @create: 2020/4/25 23:08
 * @author: dongboye
 */
public class MergeAndSortIndex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//个数
        Map<Integer, Integer> map = new TreeMap<>();
        if(n > 0){
            for(int i=0; i< n; i++){
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                if(map.get(key) != null){
                    map.put(key, value + map.get(key));
                }else{
                    map.put(key, value);
                }
            }
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

    }
}
