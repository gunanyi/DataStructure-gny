package main.java.datastructure.queue;

import java.util.Stack;

/**
 * 单向链表
 */
public class SignLinkedListDemo<E> {
    private LinkNode<E> head;          // 记录头节点
    private int length = 0;         // 记录链表长度
    public SignLinkedListDemo(){
        head = new LinkNode(null,-1);
    }


    // 添加一个节点
    public void add(E e){
        final LinkNode linkNode = new LinkNode(e,0);
        LinkNode linkNode1 = head;
        // 找到链表中最后一个节点
        while(linkNode1.next!=null){
            linkNode1 = linkNode1.next;
        }
        linkNode1.next = linkNode;
        length++;
    }

    // 遍历链表
    public void show(){
        LinkNode headtemp = head;
        while(headtemp.next!=null){
            System.out.printf(headtemp.toString());
            headtemp = headtemp.next;
        }
        System.out.printf(headtemp.toString());
    }
    // 判断链表是否为null
    public boolean isEmpty(){
        return head.next == null;
    }
    // 从链表中取一个数据
    public E get(){
        if(isEmpty()){
            throw new RuntimeException("链表为空，无法获取数据");
        }
        LinkNode<E> currentNode = head.next;
        head.next = currentNode.next;
        return currentNode.data;
    }

    // 添加节点带排序
    public void addAndSort(E e,int sort){
        LinkNode headTemp = head;
        LinkNode newNode = new LinkNode(e,sort);
        boolean result = true;
        while(headTemp.next!=null){
            if(headTemp.next.sort == sort){
                result = false;
                break;
            }
            else if(headTemp.next.sort > sort){
               break;
            }
            headTemp = headTemp.next;
        }
        if(!result){
            System.out.printf("添加失败，当前名称已有数据");
        }else{
            newNode.next = headTemp.next;
            headTemp.next = newNode;
        }

        return;
    }

    // 修改节点
    public void modify(E e,int sort){
        LinkNode newNode = new LinkNode(e,sort);
        boolean flag = false;
        LinkNode temp = head;
        while(temp.next!=null){
            if(temp.next.sort == sort){
                temp.next.data = e;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(false){
            System.out.printf("更新数据成功");
        }else {
            System.out.printf("未在链表中找到要更新的位置");
        }
    }
    // 删除节点
    public void delete(int sort){
        LinkNode temp = head;
        boolean falg = false;
        while(temp.next!=null){
            if(temp.next.sort == sort){
                falg = true;
                break;
            }
            temp = temp.next;
        }
        if(!falg){
            System.out.printf("删除节点失败，没有此节点");
        }else{
            LinkNode next = temp.next;
            temp.next = next.next;
            next = null;
        }
    }
    // 获取链表有效长度
    public int size(){
        int count = 0;
        LinkNode temp = head;
        while (temp.next!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    // 获取链表倒数的n个节点
    public E get4last(int n){
        LinkNode temp = head;
        int length = size();
        if(n>length) return null;
        for(int i=0;i<length-n;i++){
            temp = temp.next;
        }
        return (E) temp.next.data;
    }
    // 获取头节点
    public LinkNode getHead(){
        return this.head;
    }
    // 反转链表
    public void fanzhuan(SignLinkedListDemo linkedListDemo){
        LinkNode headTemp = head.next;
        LinkNode temp = headTemp.next.next;
        while(temp!=null){
            headTemp.next = temp.next;
            temp.next = head.next;
            head.next = temp;
            temp = headTemp.next;
        }

    }
    // 反向打印链表
    public void last4Show(){
        LinkNode headTemp = head;
        Stack<LinkNode> stack = new Stack<>();
        while(headTemp.next!=null){
            stack.push(headTemp.next);
            headTemp = headTemp.next;
        }
        while(!stack.empty()){
            System.out.printf(stack.pop().data.toString());
        }
        stack = null;
    }

    // 节点
    private static class LinkNode<E>{
        private E data;
        private int sort;
        private LinkNode next;

        // 构造器
        public LinkNode(E e,int sort){
            this.data = e;
            this.sort = sort;
        }
        // 重写toString方法

        @Override
        public String toString() {
            return "LinkNode{" +
                    "data=" + data +
                    '}';
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }
    }

}
