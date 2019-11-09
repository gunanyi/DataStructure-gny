package main.java.datastructure.queue;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        CircyeQueue arrayQueue = new CircyeQueue(4);
        char key = ' ';         // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while(loop){
            System.out.println("s(show)  显示队列");
            System.out.println("e(exit)  退出");
            System.out.println("a(add)  添加数据");
            System.out.println("g(get)  获取数据");
            System.out.println("h(head)  显示头数据");
            System.out.println("l(last)  显示尾数据");
            key = scanner.next().charAt(0);  // 第一个字符
            switch (key){
                case 's':
                    arrayQueue.show();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.print("退出");
                    break;
                case 'a':
                    System.out.print("输入一个值");
                    int i = scanner.nextInt();
                    arrayQueue.add(i);
                    break;
                case 'g':
                    try{
                        int i1 = arrayQueue.get();
                        System.out.print("取出一个数据 "+i1);
                    }catch (RuntimeException e){
                        System.out.print(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int i1 = arrayQueue.head();
                        System.out.print("头数据:"+i1);
                    }catch (RuntimeException e){
                        System.out.print(e.getMessage());
                    }
                    break;
                case 'l':
                    try{
                        int last = arrayQueue.last();
                        System.out.print("尾数据:"+last);
                    }catch (RuntimeException e){
                        System.out.print(e.getMessage());
                    }
                    break;
                case 'f':
                    int i1 = arrayQueue.avliLen();
                    System.out.printf("有效长度:"+i1);
                    break;
                default:
                    break;

            }
        }
    }
}
