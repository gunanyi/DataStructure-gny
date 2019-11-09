package main.java.datastructure.queue.约瑟夫;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.List;

/**
 * 环形链表
 * @param <E>
 */
public class QueueH<E> {
    private LinkNode<E> first;   // 第一个节点
    private LinkNode<E> curNode; // 最后一个节点
    private List<E> list = new ArrayList<>();        // 保存出链表顺序
    public QueueH(){

    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    // 添加节点
    public void add(E e){
        LinkNode node = new LinkNode(e);
        if(first==null){        // 链表为null
            first = node;
            curNode = node;
        }else{                  // 链表不为null
            curNode.next = node;
            curNode = node;
        }
        // 形成环
        curNode.next = first;
    }
    // 遍历环形链表
    public void show(){
        LinkNode temp = first;
        while(temp.next != first){
            System.out.printf(temp.data.toString());
            temp = temp.next;
        }
        System.out.printf(curNode.data.toString());
    }

    // 根据输入产生出队列
    public void popAll(int temp){
        LinkNode<E> cur = curNode;
        LinkNode<E> headT = first;
        while(headT.next != headT){
            for(int i=0;i<temp-1;i++){
                headT = headT.next;
                cur = cur.next;
            }
            list.add(headT.data);
            cur.next = headT.next;
            headT = headT.next;
        }
        list.add(headT.data);
    }

    private static class LinkNode<E>{
        E data;
        LinkNode next;
        public LinkNode(E e){
            this.data = e;
        }

        @Override
        public String toString() {
            return "LinkNode{" +
                    "data=" + data +
                    '}';
        }
    }
}
