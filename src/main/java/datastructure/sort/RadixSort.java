package main.java.datastructure.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,745,14,214};
        System.out.println(-1%10);
        doRadixSort(arr);
    }
    // 进行基数排序
    private static void doRadixSort(int[] arr) {
        // 需要十个数组  使用二维数组表示
        int[][] radixArr = new int[10][arr.length];
        // 需要一个数组记录各个数组中存的数
        int[] numArr = new int[10];
        // 获取这组数据中最长的位数来确定排序的次数
        int maxLen = getMaxLen(arr);
        int temp = 1;  // 用来依次取尾数
        int endNum = 0; //尾数
        int index = 0;
        // 开始循环
        for(int i=0;i<maxLen;i++){
            index = 0;
            // 第i次处理
            for(int j = 0 ; j < arr.length ; j++){
                endNum = (arr[j]/temp) % 10;        // 取尾数
                radixArr[endNum][numArr[endNum]++] = arr[j];    // 放到尾数对应的那个数组中
            }
            // 从十个数组中取数据依次放入原数组中
            for(int k = 0 ; k < 10 ; k++){
                for(int h = 0 ; h < numArr[k] ; h++){
                    arr[index++] = radixArr[k][h];
                }
                numArr[k] = 0;      // 取完数据后 记录十个数组中存储数据的数组设为0
            }
            // temp*10 取下一位
            temp = temp * 10;
        }
        System.out.println("排序结果:" + Arrays.toString(arr));

    }
    // 找到最大的数的长度
    private static int getMaxLen(int[] arr) {
        int maxLen = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if((arr[i]+"").length() > maxLen)
                maxLen = (arr[i]+"").length();
        }
        return maxLen;
    }
}
