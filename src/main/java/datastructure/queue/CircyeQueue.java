package main.java.datastructure.queue;

/**
 * 数组实现环形队列
 */
public class CircyeQueue {
    private int maxSize;        // 最大容量  预留一个位置
    private int front;          // 头指针，指向第一个元素
    private int rear;           // 尾指针，指向最后一个元素的后一个位置，预留一个位置
    private int[] data;         // 存储数据的数组

    // 初始化数组
    public CircyeQueue(int maxSize){
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        data = new int[maxSize];
    }
    // 是否为空
    public boolean isEmpty(){
        return front==rear;
    }
    // 是否为满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }
    // 添加数据
    public void add(int element){
        if(isFull()){
            System.out.print("队列以满，无法添加!");
            return;
        }
        data[rear] = element;
        rear = (rear+1)%maxSize;
    }
    // 获取数据
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取数据");
        }
        int result = data[front];
        front = (front+1)%maxSize;
        return result;
    }
    // 获取数据的有效长度
    public int avliLen(){
        if(isEmpty())
            return 0;
        return (rear+maxSize-front)%maxSize;
    }
    // 展示数据
    public void show(){
        if(isEmpty()){
            System.out.printf("队列为空");
            return;
        }
        for(int i=front;i<front+avliLen();i++){
            System.out.printf("arr[%d]=%d",(i%maxSize),data[i%maxSize]);
        }
    }
    // 展示头数据
    public int head(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return data[front];
    }
    // 展示尾数据
    public int last(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return data[(rear+maxSize-1)%maxSize];
    }
}
