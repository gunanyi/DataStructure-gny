package main.java.datastructure.sort;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,-20};
        doQuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }



    // 快速排序 对冒泡排序的优化  找一个基数， 左边都小于这个基数  右边都大于这个基数
    private static void doQuickSort(int[] arr,int lo , int hi) {
        if(lo >= hi)
            return;
        if(hi <= lo+10){
            // 改用插入排序提升性能
        }
        int l = lo;
        int h = hi+1;
        int cur = arr[lo];
        while(true){
            while(arr[++l]<cur){
              if(l == hi)
                  break;
            }
            while(arr[--h] > cur){
                if(h == lo)
                    break;
            }
            if(l>=h)
                break;
            swap(arr,l,h);
        }
        swap(arr,lo,h);
        System.out.println("一次排序:"+Arrays.toString(arr));
        doQuickSort(arr,lo,h-1);
        doQuickSort(arr,h+1,hi);
    }
    // 交换两个数
    private static void swap(int[] arr, int temp, int i) {
        int t = arr[temp];
        arr[temp] = arr[i];
        arr[i] = t;
    }
}
