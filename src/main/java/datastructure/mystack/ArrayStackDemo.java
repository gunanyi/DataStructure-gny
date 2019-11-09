package main.java.datastructure.mystack;

public class ArrayStackDemo<E> {
    private Object[] data;       // 数组
    private int maxSize;    // 最大容量
    private int top;        // 表示栈顶，初始化为-1

    public ArrayStackDemo(int cap){
        top = -1;
        data = new Object[cap];
        this.maxSize = cap;
    }

    // 判断栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
    // 栈空
    public boolean isEmpty(){
        return top == -1;
    }
    // 入栈
    public void push(E e){
        if(isFull()){
            System.out.printf("栈已满");
            return;
        }
        top++;
        data[top] = e;
    }
    // 出栈
    public E pop(){
        // 判断栈是否为null
        if(isEmpty())
            throw new RuntimeException("栈为空");
        E res = (E) data[top];
        top--;
        return res;
    }
    // 遍历栈
    public void show(){
        // 判断栈是否为空
        if(isEmpty())
            throw new RuntimeException("栈空");
        int topTemp = top;
        for(int i=topTemp;i>=0;i--){
            System.out.println(data[i].toString()+"\t");
        }
    }
}
