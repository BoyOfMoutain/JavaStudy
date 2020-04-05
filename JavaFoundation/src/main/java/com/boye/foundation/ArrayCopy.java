package com.boye.foundation;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 数组的4种拷贝
 */
public class ArrayCopy {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int[] arr1 = new int[5];
        IntStream.range(0, arr.length).forEach(i -> arr1[i] = arr[i]);
        printArray(arr1);

        int[] arr2 = new int[5];
        System.arraycopy(arr, 0, arr2, 0, arr2.length);
        printArray(arr2);

        int[] arr3 =  Arrays.copyOf(arr, arr.length);
        printArray(arr3);

        int[] arr4 = arr.clone();
        printArray(arr4);
    }

    private static void printArray(int[] arr){
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
