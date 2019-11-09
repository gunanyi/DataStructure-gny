package main.java.datastructure.queue;

import sun.awt.image.ImageWatched;

public class DoubleLinkedListDemo<E> {
    private LinkNode<E> head;
    private LinkNode<E> last;
    private int size;
    public DoubleLinkedListDemo(){
    }
    // 链表是否为null
    public boolean isEmpty(){
        return head == null;
    }
    // 获取头节点
    public E getHead(){
        if(head==null)
            throw new RuntimeException("链表为null");
        return head.data;
    }
    // 获取尾节点
    public E getLast(){
        if(last==null)
            throw new RuntimeException("链表为null");
        return last.data;
    }
    // 向链表添加数据
    public void add(E e){
        LinkNode node = new LinkNode(e);
        LinkNode headTemp = head;
        if(headTemp == null){
            head = node;
        }else{
            while(headTemp.next!=null)
                headTemp = headTemp.next;
            headTemp.next = node;
            node.pre = headTemp;
        }
        last = node;
    }

    // 按照顺序添加
    public void addAndSort(E e, int sort){
        boolean flag = true;
        LinkNode<E> node = new LinkNode<>(e,sort);
        LinkNode headTemp = head;
        if(head == null){   // 头节点为null
            head = node;
            last = node;
            flag = false;
        }else {
            while(headTemp != null){
                if(headTemp.sort == sort){
                    System.out.printf("添加失败，排序已存在");
                    flag = false;
                    break;
                }
                // 添加到目标节点前
                if(headTemp.sort > sort){
                    break;
                }
                headTemp = headTemp.next;
            }
        }
        // 执行添加
        if(flag){
            if(headTemp == null){
                last.next = node;
                node.pre = last;
                last = node;
            }
             else if(headTemp.pre == null){  // 头节点
                node.next = headTemp;
                headTemp.pre = node;
                head = node;
            }else{ // 非头节点
                node.next = headTemp;
                node.pre = headTemp.pre;
                headTemp.pre.next = node;
                headTemp.pre = node;
            }
        }
    }
    // 修改
    public void modfiy(E e,int sort){
        LinkNode headTemp = head;
        while(headTemp != null){
            if(headTemp.sort == sort){
                headTemp.data = e;
                break;
            }
            headTemp = headTemp.next;
        }
    }
    // 按照排序删除
    public void del(int sort){
        LinkNode headTemp = head;
        boolean flag = false;
        while(headTemp != null){
            if(headTemp.sort == sort){
                flag = true;
                break;
            }
            headTemp = headTemp.next;
        }
        if(flag){ // 删除
            if(headTemp.next == null){
                last = last.pre;
            }
            if(headTemp.pre == null){
                head = headTemp.next;
                if(head != null){
                    head.pre = null;
                    headTemp = null;
                }
            }else {
                headTemp.pre.next = headTemp.next;
                if(headTemp.next != null){
                    headTemp.next.pre = headTemp.pre;
                }
                headTemp = null;
            }
        }
    }

    // 从链表删除数据
    public E get(){
        if(isEmpty())
            throw new RuntimeException("链表为null");
        LinkNode<E> node = head;
        E e = null;
        if(head.next==null){
            e = head.data;
        }else{
            head = head.next;
            head.pre = null;
            e = node.data;
        }
        node = null;
        return e;
    }
    // 展示链表数据
    public void show(){
        LinkNode headTemp = head;
        while(headTemp != null){
            System.out.println(headTemp.data.toString());
            headTemp = headTemp.next;
        }
    }

    private static class LinkNode<E> {
        E data;
        int sort;
        LinkNode pre;
        LinkNode next;
        public LinkNode(E e){
            this.data = e;
        }
        public LinkNode(E e,int sort){
            this.data = e;
            this.sort = sort;
        }
        @Override
        public String toString() {
            return "LinkNode{" +
                    "data=" + data.toString() + ",sort=" + sort+
                    '}';
        }
    }
}
