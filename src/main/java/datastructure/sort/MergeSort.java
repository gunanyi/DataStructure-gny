package main.java.datastructure.sort;

import java.util.Arrays;

public class MergeSort {
    static int[] arr1 = new int[8];
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        preMergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr1));
    }
    // 归并排序准备
    private static void preMergeSort(int[] arr , int lo , int hi) {
        int mid = 0;
        if(lo+1 != hi){
            mid = lo + (hi - lo +1) /2;
            preMergeSort(arr,lo,mid-1);
            preMergeSort(arr,mid,hi);
        }
        // 合并
        merge(arr,lo,hi);
    }
    // 合并
    private static void merge(int[] arr, int lo, int hi) {
        System.out.printf("开始合并lo=%d,hi=%d\n",lo,hi);
        int mid = 0;
        int i= lo;
        int j = 0;
        int temp = lo;
        if(lo+1 == hi){
            if(arr[lo] > arr[hi]){
                arr1[lo] = arr[hi];
                arr1[hi] = arr[lo];
            }else{
                arr1[lo] = arr[lo];
                arr1[hi] = arr[hi];
            }
        }else{
            mid = lo + (hi-lo+1)/2;
            j = mid;
            while(i<mid && j<=hi){
                if(arr[i] < arr[j]){
                    arr1[temp++] = arr[i];
                    i++;
                }else{
                    arr1[temp++] = arr[j];
                    j++;
                }
            }
            if(i==mid){
                for(int x = j;x<=hi;x++){
                    arr1[temp++] = arr[x];
                }
            }
            else if(j == hi+1){
                for(int x = i;x<mid;x++){
                    arr1[temp++] = arr[x];
                }
            }
        }
        for(int x=lo;x<=hi;x++){
            arr[x] = arr1[x];
        }
    }


}
