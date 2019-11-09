package main.java.datastructure.sort;

import java.util.Arrays;

public class GHeapSort {
    public static void main(String[] args) {
        int[] arr = {14,25,10,65,24,75,26,85,36};
        int temp = 0;
        // 构造最大堆，从最后一个非叶子节点元素开始构建最大堆。
        for(int i=(arr.length-1)/2;i>=0;i--){
            doSort(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));
        // 排序阶段，交换最大元素位置，下沉
        for(int i=arr.length-1;i>0;i--){
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            doSort(arr,0,i);
        }
        System.out.println(Arrays.toString(arr));
    }
    // 把最大值
    public static void doSort(int[] arr , int i , int len){
        // 从i开始调整
        int k = 0 ;
        int temp = arr[i];
        for(;(k=i*2+1)<len;){
            if(k+1<len&& arr[k] < arr[k+1]){
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
