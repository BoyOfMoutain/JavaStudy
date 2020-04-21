package com.boye.foundation;

import java.util.Arrays;

public class FoundationSort {

    public static void main(String[] args) {
        int[] arr = {27, 25, 6 , 10, 7, 14, 13};

        int[] a1 = Arrays.copyOf(arr, arr.length);
        selectSort(a1);
        printArray(a1);

        int[] a2 = Arrays.copyOf(arr, arr.length);
        bubbleSort(a2);
        printArray(a2);

        int[] a3 = Arrays.copyOf(arr, arr.length);
        insertSort(a3);
        printArray(a3);

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
    /**
     * 选择排序
     * @param arr int[]
     */
    private static void selectSort(int[] arr){
        for (int i = 0; i < arr.length -1; i++) {
            for (int j =  i+ 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * @param arr int[]
     */
    private static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr int[]
     */
    private static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {//前i个进行交换
                if (arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }

    /**
     * 快排
     * @param arr int[]
     * @param low 低位
     * @param high 高位
     */
    private static void quickSort(int[] arr, int low, int high){
        if(arr == null || arr.length <= 1 || low >= high){
            return;
        }
        int i = low, j = high, p = arr[(high - low) / 2 + low];
        while(i <= j){//这个算法就是把小于p的数字放在左边，大于p的数字放在右边
            while(arr[i] < p){//前面的数字与p比较，比p小的话，就让i+1，相当于往后挪一位
                ++i;
            }
            while(arr[j] > p){//后面的数字与p比较，比p大的话，就让j-1，相当于往前挪一位
                --j;
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
