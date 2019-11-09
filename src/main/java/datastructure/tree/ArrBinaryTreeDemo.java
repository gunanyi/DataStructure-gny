package main.java.datastructure.tree;

/**
 * 以数组存储二叉树的 前中后序遍历
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        prelist(arr);
    }

    /**
     * 先序遍历
     * 使用重载来添加默认值
     * @param arr
     */
    public static void prelist(int[] arr){
        prelist(arr,0);
    }

    private static void prelist(int[] arr, int cur) {
        if(arr == null || cur >= arr.length)
            return;
        System.out.println(arr[cur]);
        prelist(arr,2*cur+1);
        prelist(arr,2*cur+2);
    }
}
