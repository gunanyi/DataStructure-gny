package main.java.datastructure.sort;

import java.util.Arrays;

public class InserationSort {
    public static void main(String[] args) {
        int[] arr = {-3,-1,5,3,-2,10,8};
        doInserationSort(arr);
        System.out.println("排序结果:"+ Arrays.toString(arr));
    }
    // 插入排序
    private static void doInserationSort(int[] arr) {
        int j=0; int cur = 0;
        for(int i=1;i<arr.length;i++){
            // 插入排序
            j = i;
            cur = arr[i];
            while(j>0 && cur<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            if(j != i)
            arr[j] = cur;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
