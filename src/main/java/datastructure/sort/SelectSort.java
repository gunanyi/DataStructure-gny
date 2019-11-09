package main.java.datastructure.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {-1,-3,4,-2,10,3};
        doSelectSort(arr);
    }

    /**
     * 选择排序
     * @param arr
     */
    private static void doSelectSort(int[] arr) {
        int min = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[min]>arr[j])
                    min = j;
            }
            if(min != i)
            swap(arr,min,i);
        }
        System.out.println("排序结果:"+ Arrays.toString(arr));
    }
    // 交换值
    private static void swap(int[] arr, int min, int i) {
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
    }
}
