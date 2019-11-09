package main.java.datastructure.mystack;

/**
 * 链表实现栈
 * @param <E>
 */
public class LinkedStackDemo<E> {
    private LinkNode<E> top;        // 指向栈顶

    // 栈是否为空
    public boolean isEmpty(){
        return top == null;
    }
    // 添加数据
    public void push(E e){
        LinkNode node = new LinkNode(e);
        if(top!=null){
            node.next = top;
        }
        top = node;
    }
    // 获取数据
    public E pop(){
        if(isEmpty())
            throw new RuntimeException("栈为空");
        E res = top.data;
        LinkNode node = top;
        top = top.next;
        node = null;
        return res;
    }
    // 遍历栈
    public void show(){
        LinkNode temp = top;
        while(temp!=null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }
    // 节点
    private static class LinkNode<E>{
        E data;
        LinkNode next;

        public LinkNode(E e){
            this.data = e;
        }
    }

}
