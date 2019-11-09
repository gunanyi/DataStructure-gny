package main.java.datastructure.sort;

import java.util.Arrays;

/**
 * 堆排序 大顶堆 升序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {14,25,10,65,24,75,26,85,36};
        constractHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 构造最大堆
     * @param arr  数组
     */
    public static void constractHeap(int[] arr){
        //int i = arr.length - 1;
        int tempi = 0;
        for(int i = arr.length-1;(i-1)/2>=0;i--){
            tempi = i;
            while(tempi > 0){
                if(tempi % 2 ==0 && arr[tempi-1] > arr[tempi]){
                    tempi--;
                }
                if(arr[tempi] > arr[(tempi-1)/2]){
                    swap(arr,tempi,(tempi-1)/2);
                    down(arr,tempi,i);
                }
                tempi = tempi-2;
            }
            swap(arr,0,i);
            down(arr,0,i-1);
        }
    }
    // 下沉
    private static void down(int[] arr, int i,int len) {
        int tempi = 0;
        while((tempi = i*2+1) <= len){
            if(tempi+1 <=len){
                if(arr[tempi] < arr[tempi+1]){
                    tempi++;
                }
            }
            if(arr[tempi] > arr[i]){
                swap(arr,tempi,i);
                i = tempi;
            }else
                break;
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i] ;
        arr[i] =  arr[i1] ;
        arr[i1] = temp;
    }

    // 上浮
    private static void flow(int[] arr, int i) {

    }
}
