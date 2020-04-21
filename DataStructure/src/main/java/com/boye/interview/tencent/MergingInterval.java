package com.boye.interview.tencent;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 */
public class MergingInterval {

    public static void main(String[] args) {
        int[][] intervals = {{2,8}, {1,3}, {8,10}, {15,18}};
        printArray(intervals);
        System.out.println("----------------------");
     //   Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
       // printArray(intervals);
      //  System.out.println("----------------------");
        printArray(merge(intervals));
    }

    private static void printArray(int[][] intervals){
        for (int i = 0; i < intervals.length; i++) {
            int[] ints = intervals[i];
            for (int j = 0; j <ints.length ; j++) {
                System.out.print(ints[j]+"\t");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            if(idx == -1 || res[idx][1] < interval[0]){
                res[++idx] = interval;//循环下一个元素
            }else{//合并
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
