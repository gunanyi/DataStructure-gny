package main.java.datastructure.sorttest;

import java.util.Arrays;

public class ThreeQuick {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,-20};
        doThreeQuick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    // 三路快排
    private static void doThreeQuick(int[] arr, int lo, int hi) {
        if(lo >= hi){
            return;
        }
        int lt = lo;
        int gt = hi;
        int i = lo+1;
        int cur = arr[lo];
        int compare = 0;
        while(i<=gt){
            if(arr[i] > cur){
                compare = 1;
            }else if(arr[i] < cur){
                compare = -1;
            }
            if(compare == 1){
                swap(arr,i,gt);
                gt--;
            }
            else if(compare == -1){
                swap(arr,i,lt);
                i++;
                lt++;
            }else{
                i++;
            }
        }
        doThreeQuick(arr,lo,lt-1);
        doThreeQuick(arr,gt+1,hi);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp;
    }
}
