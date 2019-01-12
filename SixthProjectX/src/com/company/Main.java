package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        permute(arr,arr.length);
    }

    private static void permute(int[] arr, int size) {
        if (size<2){
            System.out.println(Arrays.toString(arr));
        }else{
            for (int i = 0; i <size ; i++) {
                swap(arr, i, size - 1);
                permute(arr, size - 1);
                swap(arr, size - 1, i);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
