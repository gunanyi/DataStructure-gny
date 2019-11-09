package main.java.datastructure.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {-3,-1,0,9,1,-5,4,-9,10};
        doShellSort(arr);
    }
    // 进行希尔排序，分组排序，并逐渐减少分组，最后只剩一个分组就是简单插入排序
    private static void doShellSort(int[] arr) {
        int temp = (arr.length+1) / 2;
        int j = 0;
        int cur = 0;
        while(temp>0){
           for(int i=0+temp;i<arr.length;i++){
               j = i;
               cur = arr[i];
               while(j-temp>=0 && cur < arr[j-temp]){
                   arr[j] = arr[j-temp];
                   j = j -temp;
               }
               if(j!=i)
                   arr[j] = cur;
           }
           System.out.println("希尔排序:"+Arrays.toString(arr));
           temp = temp / 2;
        }
        System.out.println("排序完成:"+ Arrays.toString(arr));
    }
}
