package main.java.datastructure.tree;

import main.java.datastructure.tree.model.Emp;

public class TreeTest {
    public static void main(String[] args) {
        Emp emp = new Emp(1,"root");
        Emp emp1 = new Emp(2,"left");
        Emp emp2 = new Emp(2,"right");
        Emp emp3 = new Emp(3,"left");
        Emp emp4 = new Emp(4,"right");
        BinaryTreeDemo<Emp> binaryTreeDemo = new BinaryTreeDemo<>(emp);
        BinaryTreeDemo.TreeNode<Emp> root = binaryTreeDemo.getRoot();
        binaryTreeDemo.addLeft(root,emp1);
        binaryTreeDemo.addRight(root,emp2);
        binaryTreeDemo.addLeft(root.left,emp3);
        binaryTreeDemo.addRight(root.left,emp4);

        //Emp res = binaryTreeDemo.endFind(root,emp);
        //System.out.println(res);
        // 前序 preList
        //binaryTreeDemo.preList(root);
        // 中序 infixList
        //binaryTreeDemo.preList(root);
        // 后序 endList
        //binaryTreeDemo.preList(root);
        //binaryTreeDemo.preList(root);
        //boolean b = binaryTreeDemo.delNode(root, emp2);
        //System.out.println(b);
        //binaryTreeDemo.preList(root);
        binaryTreeDemo.threadedBinaryTree(root);
        System.out.println("线索完毕");
        binaryTreeDemo.thrededlist(root);
    }
}
