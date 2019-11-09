package main.java.datastructure.search;

import java.util.Arrays;

/**
 * 插值查找 公式 mid = lo + (hi-lo) * (cur-a[lo])/(arr[hi] - arr[lo])
 */
public class InsertValueSearsh {
    public static void main(String[] args) {
        int [] arr = {9,5,3,4,8,1,2,6,7};
        doQuickSort(arr,0,arr.length-1);        // 快速排序
        System.out.println(Arrays.toString(arr));
        int result = doInsertSearsh(arr,5);
        System.out.println("找到的下标:"+result);
    }
    // 插值查找
    private static int doInsertSearsh(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;
        int mid = 0;
        int compare = 0;
        int result =-1;
        while(lo <= hi){
            if(target < arr[lo] || target > arr[hi]){
                break;
            }
            mid = lo + (hi-lo) * (target - arr[lo]) / (arr[hi] - arr[lo]);
            if(arr[mid] > target){
                compare = 1;
                hi = mid -1;
            }else if(arr[mid] < target){
                compare = -1;
                lo = mid +1;
            }else {
                result = mid;
                break;
            }

            System.out.println("=========");
        }
        return result;
    }
    // 快速排序
    private static void doQuickSort(int[] arr, int lo, int hi) {
        if(lo >= hi){
            return;
        }
        int l = lo;
        int cur = arr[lo];
        int h = hi+1;
        while(true){
            while(arr[++l] < cur){
                if(l == hi)
                    break;
            }
            while(arr[--h] > cur){
                if(h == lo)
                    break;
            }
            if(l >= h ){
                break;
            }
            swap(arr,l,h);
        }
        swap(arr,lo,h);
        doQuickSort(arr,lo,h-1);
        doQuickSort(arr,h+1,hi);
    }
    // 交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
