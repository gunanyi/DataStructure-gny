package main.java.datastructure.tree;

import main.java.datastructure.tree.model.Emp;


/**
 * 二叉树实现
 */
public class BinaryTreeDemo<E> {
    TreeNode<E> root;
    TreeNode<E> pre;
    public BinaryTreeDemo(E e){
        root = new TreeNode<>(e);
    }

    public TreeNode<E> getRoot() {
        return root;
    }
    // 添加左节点
    public void addLeft(TreeNode<E> parent, E e){
        TreeNode<E> temp = new TreeNode<>(e);
        parent.left = temp;
    }
    // 添加右节点
    public void addRight(TreeNode<E> parent,E e){
        TreeNode<E> temp = new TreeNode<>(e);
        parent.right = temp;
    }
    // 线索化二叉树遍历
    public void thrededlist(TreeNode<E> node){
        while (node != null){
            System.out.println(node.data);
            while(node.rightType != 1){
                System.out.println(node.left.data);
                node = node.left;
            }
            while(node.rightType == 1){
                node = node.right;
                System.out.println(node.data);
            }
            if(node.leftType == 1 && node.right ==null){
                break;
            }else {
                node = node.left;
            }

        }
    }

    // 线索化二叉树  left指向左子节点或前驱节点  right指向右节点或后序节点  前序遍历实现 leftType 0 子树 1 前驱
    public void threadedBinaryTree(TreeNode<E> node){
        if(node == null){
            return;
        }
        // 先线索化当前节点
        if(node.left == null){
            node.left = pre;
            node.leftType = 1;
        }
        if(pre != null && pre.right==null){
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
        // 线索化左节点
        if(node.leftType != 1)
            threadedBinaryTree(node.left);
        // 线索化右节点
        if(node.rightType != 1)
        threadedBinaryTree(node.right);
    }

    // 递归删除节点 true找到并删除 false没找到要删除的节点
   public boolean delNode(TreeNode<E> parent,E e){
        if(parent == root){
            if(compare(e,parent.data)){
                root = null;
            }
        }
        if( null == parent ){
            return false;
        }
        boolean result = false;
        if(compare(e,parent.left.data)){         // 比较当前节点
            doDel(parent);
            parent.left = null;
            return true;
        }else if(compare(e,parent.right.data)){
            doDel(parent.right);
            parent.right = null;
            return true;
        }

        if(null != parent.left){            // 向左递归
            result = delNode(parent.left,e);
        }
        if(!result && null != parent.right){
            result = delNode(parent.right,e);
        }
        return result;
    }
    // 删除节点
    private void doDel(TreeNode<E> node) {
        if(node == null)
            return;
        TreeNode<E> left = null;
        TreeNode<E> right = null;
        if(node.left!=null){
            left = node.left.left;
            right = node.left.right;
            node.left = null;
            doDel(left);
            doDel(right);
        }else if(node.right != null){
            left = node.right.left;
            right = node.right.right;
            node.right = null;
            doDel(left);
            doDel(right);
        }
    }

    // 先序查找
    public E preFind(TreeNode<E> parent,E e){
        E result = null;
        if(parent == null)
            return null;
        System.out.println("寻找路径："+parent.data);
        if(compare(e,parent.data)){
            return parent.data;
        }
         if((result = preFind(parent.left,e)) == null){
             return preFind(parent.right,e);
         }else {
             return result;
         }
    }

    // 中序查找
    public E infixFind(TreeNode<E> parent,E e){
        E result = null;
        if(parent == null)
            return null;
        if((result = infixFind(parent.left,e))==null){
            System.out.println("寻找路径："+parent.data);
            if(compare(e,parent.data))
                return parent.data;
        }else {
            return result;
        }
        return infixFind(parent.right,e);
    }

    // 后序查找
    public E endFind(TreeNode<E> parent,E e){
        E result = null;
        if(parent == null)
            return null;

        if((result = endFind(parent.left,e)) == null){
            if((result = endFind(parent.right,e))==null){
                System.out.println("寻找路径:"+parent.data);
                if(compare(e,parent.data))
                    return parent.data;
            }else {
                return result;
            }
        }else {
            return result;
        }
        return result;
    }

    /**
     * 比较两个对象
     * @param e obj1
     * @param data obj2
     * @return 是否相等
     */
    private boolean compare(E e, E data) {
        if(e == data)
            return true;
        if(e==null || e.getClass()!=data.getClass())
            return false;
        Emp obj1 = null;
        Emp obj2 = null;
        if(e.getClass() == Emp.class){
            obj1 = (Emp) e;
        }
        if(data.getClass() == Emp.class){
            obj2 = (Emp) data;
        }
        if(obj1 == null || obj2 == null)
            return false;
        if(obj1.getId() != obj2.getId())
            return false;
        return obj1.getName().equals(obj2.getName());

    }

    /**
     * 先输出父节点，再左，再右
     * @param temp 前序遍历
     */
    public void preList(TreeNode temp){
        if(temp==null)
            return;
        System.out.println(temp.data.toString());
        preList(temp.left);
        preList(temp.right);
    }

    /**
     * 先左，再父，再右
     * @param temp 中序遍历
     */
    public void infixList(TreeNode temp){
        if(temp == null)
            return;
        infixList(temp.left);
        System.out.println(temp.data.toString());
        infixList(temp.right);
    }

    // 后序遍历
    public void endList(TreeNode temp){
        if(temp == null)
            return;
        endList(temp.left);
        endList(temp.right);
        System.out.println(temp.data.toString());
    }


    public static class TreeNode<E>{
        E data;
        TreeNode<E> left;
        TreeNode<E> right;
        int leftType = 0;           // 0子树 1 前驱或后继
        int rightType = 0;

        public TreeNode(){

        }
        public TreeNode(E e){
            this.data = e;
        }

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }

        public TreeNode<E> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<E> left) {
            this.left = left;
        }

        public TreeNode<E> getRight() {
            return right;
        }

        public void setRight(TreeNode<E> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }
}
