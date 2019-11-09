package main.java.datastructure.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,-1,9,10,-2};
        doBubbleSort(arr);
        System.out.println("排序结果:"+ Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    private static void doBubbleSort(int[] arr) {
        boolean flag = true;
        for(int i=0;i<arr.length-1;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    swap(arr,j-1,j);
                    flag = false;
                }
            }
            if(flag)
                break;
            else
                flag = true;    // 重置flag
        }
    }

    /**
     * 交换元素i和j的值
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
