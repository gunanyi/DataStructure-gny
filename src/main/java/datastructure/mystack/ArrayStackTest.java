package main.java.datastructure.mystack;

import main.java.datastructure.queue.model.Perpol;

import java.util.Scanner;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStackDemo<String> stackDemo = new ArrayStackDemo<>(5);
        boolean isExit = true;
        Scanner scanner = new Scanner(System.in);
        while(isExit){
            System.out.println("s:显示，e:退出，push:添加数据，pop：取出数据");
            System.out.println("请输入");
            String in = scanner.nextLine();
            switch (in){
                case "s":
                    stackDemo.show();
                    break;
                case "push":
                    System.out.printf("请输入一个数\n");
                    String re = scanner.nextLine();
                    stackDemo.push(re);
                    break;
                case "pop":
                    String res = null;
                    try{
                        res = stackDemo.pop();
                    }catch (Exception e){
                        System.out.printf(e.getMessage());
                        e.printStackTrace();
                    }
                    System.out.println("取出的数据："+res);
                    break;
                case "e":
                    System.out.printf("程序退出");
                    isExit = false;
                    break;
                    default:
                        break;
            }
        }
    }
}
