package main.java.datastructure.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树构建
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        doQuickSort(arr,0,arr.length-1);
        //doHeapSort(arr);
        System.out.println(Arrays.toString(arr));
        // 遍历arr构造ArrayList
        List<TreeNode> list = new ArrayList<TreeNode>();
        for(int i=0;i<arr.length;i++){
            list.add(new TreeNode(arr[i]));
        }
        System.out.println(list);
        TreeNode left = null;
        TreeNode right = null;
        TreeNode temp = null;
        // 构造赫夫曼树
        /**
         * 1.取两个最小的值组成一个子树
         * 2.接着取值来构建一个更大的子树
         */
        while(list.size()>1){
            left = list.get(0);
            right = list.get(1);
            temp = new TreeNode(left.data + right.data);
            temp.left = left;
            temp.right = right;
            list.remove(left);
            list.remove(right);
            list.add(temp);
            Collections.sort(list);
        }
        TreeNode root = list.get(0);
        TreeNode.preList(root);
    }

    // 构造赫夫曼树


    private static class TreeNode implements Comparable<TreeNode> {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.data = val;
        }

        @Override
        public int compareTo(TreeNode other) {
            return this.data - other.data;
        }
        // 前序遍历
        public static void preList(TreeNode root){
            if(root == null)
                return;
            System.out.println(root.data);
            preList(root.left);
            preList(root.right);
        }
    }

    // 堆排序
    public static void doHeapSort(int[] arr){
        // 构造最大堆
        for(int i = (arr.length-1)/2;i>=0;i--){
            doSink(arr,i,arr.length);
        }
        //堆排序
        for(int i=arr.length-1;i > 0; i--){
            swap(arr,0,i);
            doSink(arr,0,i);
        }
    }

    // 下沉  构造最大堆
    private static void doSink(int[] arr, int i,int len) {
        int temp = arr[i];
        int k = 0;
        while( (2*i+1) < len ){
            k = 2*i+1;
            if(k+1<len && arr[k+1] > arr[k])
                k++;
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else
                break;
        }
        arr[i] = temp;
    }

    //快速排序
    public static void doQuickSort(int[] arr,int lo , int hi){
        if(lo >= hi)
            return;
        int cur = arr[lo];
        int h = hi+1;
        int l = lo;
        while (true){
            while(arr[++l] < cur){
                if(l == hi){
                    break;
                }
            }
            while(arr[--h] > cur){
                if(h == lo){
                    break;
                }
            }
            if(h <= l)
                break;
            swap(arr,h,l);
        }
        swap(arr,lo,h);
        doQuickSort(arr,lo,h-1);
        doQuickSort(arr,h+1,hi);
    }

    private static void swap(int[] arr, int h, int l) {
        int temp = arr[h];
        arr[h] = arr[l];
        arr[l] = temp;
    }
}

