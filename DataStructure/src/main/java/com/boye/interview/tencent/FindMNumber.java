package com.boye.interview.tencent;

import java.util.Arrays;

/**
 * 在一个长度为n的数组中，找出最大的m个数字; (n > m)
 * 面试官
 * n = 10, 000, 000
 * 面试官
 * m = 1000
 */
public class FindMNumber {

    public static void main(String[] args) {
        int[] arr = {27, 25, 6 , 10, 7, 14, 2,2,3,55,90,12,13};
        int[] a4 = Arrays.copyOf(arr, arr.length);
        quickSort(a4, 0, a4.length - 1);
        printArray(a4);
    }

    private static void printArray(int[] arr){
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(arr == null || arr.length <= 1 || low >= high){
            return;
        }
        int i = low, j = high, p = arr[low];
        while(i <= j){//这个算法就是把小于p的数字放在左边，大于p的数字放在右边
            while(arr[j] > p && i < j){//后面的数字与p比较，比p大的话，就让j-1，相当于往前挪一位
                --j;
            }
            while(arr[i] < p && i < j){//前面的数字与p比较，比p小的话，就让i+1，相当于往后挪一位
                ++i;
            }
            if(i < j){//交换i和j的数字
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
                --j;
            }else if(i == j){
                ++i;
            }
        }
        quickSort(arr, low, j);
        quickSort(arr, i, high);
    }

}
