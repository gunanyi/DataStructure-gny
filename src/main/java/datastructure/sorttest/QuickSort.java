package main.java.datastructure.sorttest;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,-20};
        doQuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    // 快排
    private static void doQuickSort(int[] arr, int lo, int hi) {
        if(lo>=hi)
            return;
        int l = lo;
        int h = hi+1;
        int cur = arr[l];
        while(true){
            while(arr[++l] < cur){
                if(l == hi){
                    break;
                }
            }
            while(arr[--h]>cur){
                if(h == lo){
                    break;
                }
            }
            if(l>=h)
                break;
            swap(arr,l,h);
        }
        swap(arr,lo,h);
        doQuickSort(arr,lo,h-1);
        doQuickSort(arr,h+1,hi);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
