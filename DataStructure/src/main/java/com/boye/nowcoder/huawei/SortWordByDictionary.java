package com.boye.nowcoder.huawei;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>SortWordByDictionry</code>
 * @description: 根据字段来排序单词
 * @create: 2020/4/26 01:10
 * @author: dongboye
 */
public class SortWordByDictionary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.next());
        }
        Collections.sort(list);
        list.stream().forEach(System.out::println);

    }
}
