package main.java.datastructure.search;

import java.util.Arrays;

/**
 * 斐波那契排序，借助斐波那契数列
 * f[k] = f[k-1] + f[k+1]
 */
public class FibonacciSearsh {
    private static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {3,1,5,2,7,4,9,0,123,66};
        doQuickSort(arr,0,arr.length-1);
        int result = doFibonacciSearsh(arr , 7);
        System.out.println(result);
    }
    // 快速排序
    private static void doQuickSort(int[] arr, int lo, int hi) {
        if(lo >= hi)
            return;
        int l = lo;
        int h = hi + 1;
        int cur = arr[lo];
        while(true){
            while(arr[++l] < cur){
                if(l == hi)
                    break;
            }
            while(arr[--h] > cur){
                if(h == lo)
                    break;
            }
            if(l >= h)
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

    // 斐波那契查找
    private static int doFibonacciSearsh(int[] arr , int target) {
        int [] fiboArr = getFiboArr();      // 斐波那契数列
        int lo = 0;
        int hi = arr.length-1;
        int k = 0;                          // 数组长度
        int result = -1;
        while(hi > fiboArr[k]){
            k++;
        }
        int[] temp = Arrays.copyOf(arr,fiboArr[k]);  // 临时数组，后面补0，0换成arr[hi]
        for(int i=hi;i<temp.length;i++){
            temp[i] = arr[hi];
        }
        int mid = 0;
        while(lo <= hi){
            mid = lo + fiboArr[k-1] -1;
            if(target < temp[mid]){
                hi = mid -1;
                k--;        // f[k] = f[k-1] + f[k-2] 前面k-1 后面 k-2
            }else if(target > temp[mid]){
                lo = mid +1;
                k = k - 2;
            }else {
                result = mid > hi ? hi:mid;
                break;
            }
        }
        return result;
    }

    private static int[] getFiboArr() {
        int [] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        int i=2;
        while(i < maxSize){
            arr[i] = arr[i-1] + arr[i-2];
            i++;
        }
        return arr;
    }
}
