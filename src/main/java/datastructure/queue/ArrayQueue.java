package main.java.datastructure.queue;

/**
 * 使用数组来模拟队列
 */
public class ArrayQueue {
    private int maxSize;        // 队列的最大容量
    private int front;           // 队列头
    private int rear;           // 队列尾
    private int[] arr;          // 使用数组来模拟队列

    // 构造器
    public ArrayQueue(int cap){
        arr = new int[cap];
        maxSize = cap;
        rear = -1;          // 最后一个数据的下标
        front = -1;          // 第一个数据的前一个位置
    }

    // 判断队列是否满
    public boolean isFull(){
        return (rear == maxSize-1);
    }

    // 判断队列是否为null
    public boolean isEmpty(){
        return (rear == front);
    }

    // 添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.print("队列已满");
            return;
        }
        arr[++rear] = n;
    }

    // 获取队列中数据
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    // 展示队列所有数据
    public void showData(){
        if(isEmpty()){
            System.out.print("队列为空");
            return;
        }
        for(int i=front+1;i<=rear;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    // 展示头数据
    public int getHead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    // 展示尾数据
    public int getLast(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[rear];
    }
}
