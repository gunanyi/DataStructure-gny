package main.java.datastructure.sort;

import java.util.Arrays;

/**
 * 三路快排
 * lt左边小于 cur
 * gt右边 大于 cur
 */
public class ThreeQuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,-20};
        doQuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void doQuickSort(int[] arr, int lo, int hi) {
        if(lo>=hi)
            return;
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        int cur = arr[lo];
        int compare = 0;
        while(i<=gt){
            if(arr[i]>cur)
                compare = 1;
            else if(arr[i]<cur)
                compare = -1;
            if(compare < 0){
                swap(arr,i,lt);
                lt++;
                i++;
            }else if(compare>0){
                swap(arr,i,gt);
                gt--;
            }else {
                i++;
            }
        }
        doQuickSort(arr,lo,lt-1);
        doQuickSort(arr,gt+1,hi);
    }
    // 交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
