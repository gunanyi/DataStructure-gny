package main.java.datastructure.search;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearsh {
    public static void main(String[] args) {
        int[] arr = {-1,2,15,-8,7,-20,5};
        doQuickSort(arr,0,arr.length-1);   // 快速排序
        System.out.println(Arrays.toString(arr));
        int result = doBinarySearsh(arr,0,arr.length-1,15);
        System.out.println("查找结果："+result);
    }
    // 二分查找
    private static int doBinarySearsh(int[] arr, int lo, int hi , int target) {
        int mid = 0;
        int compare = 0;
        int res = -1;
        while(lo <= hi){
            mid = lo + (hi-lo)/2;
            if(arr[mid] > target){
                compare = 1;
            }else if(arr[mid] < target){
                compare = -1;
            }else {
                res = mid;
                break;
            }
            // 处理 变量！
            if(compare == 1){
                hi = mid;
            }else {
                lo = mid +1;
            }
        }
        return res;
    }
    // 快速排序
    private static void doQuickSort(int[] arr , int lo ,int hi) {
        if(lo>=hi)
            return;
        int l = lo;
        int h = hi+1;
        int cur = arr[l];
        while(true){
            while(arr[++l] < cur){
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
        doQuickSort(arr,lo,h-1);
        doQuickSort(arr ,h+1,hi);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
