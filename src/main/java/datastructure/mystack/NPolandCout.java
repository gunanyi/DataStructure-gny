package main.java.datastructure.mystack;

import main.java.datastructure.queue.SignLinkedListDemo;

import java.util.Scanner;

/**
 * 逆波兰表达式计算
 */
public class NPolandCout {
    private static  boolean loop = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infixStr = null;
        String nPolandStr = null;
        String[] nPolandArray = null;

        while(loop){
            System.out.println("请输入中缀表达式(exit退出):");
            infixStr = scanner.nextLine();
            if("exit".equals(infixStr)){
                loop = false;
                break;
            }
            nPolandStr = infix2nPoland(infixStr);
            nPolandArray = nPolandStr.split(" ");
            countNPoland(nPolandStr);

        }
    }

    /**
     * 中缀表达式转后缀表达式
     * @param infixStr
     * @return nPolandStr
     */
    private static String infix2nPoland(String infixStr) {
        String[] infixStrArray = infixStr.split(" ");
        LinkedStackDemo<String> symbolStack = new LinkedStackDemo<>(); // 符号栈
        SignLinkedListDemo<String> nPolandStack = new SignLinkedListDemo<>(); // 后缀表达式栈
        String symbolTop = null;                                        // 符号栈顶的符号
        for(int i = 0; i < infixStrArray.length; i++){// 遍历中缀表达式
            if(infixStrArray[i].matches("\\d+")){ // 数字入数栈
                nPolandStack.add(infixStrArray[i]);
            }else {                                    // 符号后错误输入
                if(infixStrArray[i].length() > 1)
                    throw new RuntimeException("操作符输入有误");
                symbolStackIsNotEmpty(infixStrArray[i],symbolStack,nPolandStack);
            }
        }
        while(!symbolStack.isEmpty()){
            symbolTop = symbolStack.pop();
            nPolandStack.add(symbolTop);
        }
        // 返回nPolandStack中的数据
        StringBuilder builder = new StringBuilder();
        while(!nPolandStack.isEmpty()){
            builder.append(nPolandStack.get());
        }
        return builder.toString();
    }

    /**
     * 处理S为符号且符号栈不为空
     * @param s
     * @param symbolStack
     * @param nPolandStack
     */
    private static void symbolStackIsNotEmpty(String s, LinkedStackDemo<String> symbolStack, SignLinkedListDemo<String> nPolandStack) {
        String symbolTop = null;                // 栈顶符号
        if(symbolStack.isEmpty() || "(".equals(s)){              // 符号栈为空
            symbolStack.push(s);
        }else{                                  // 符号栈不为空
            symbolTop = symbolStack.pop();
            symbolStack.push(symbolTop);
            if("(".equals(symbolTop)){ // 栈顶为小括号
                symbolStack.push(s);
            }else if(")".equals(s)){   // 当前操作符为右括号
                symbolTop = symbolStack.pop();
                while(!"(".equals(symbolTop)){
                    nPolandStack.add(symbolTop);
                    symbolTop = symbolStack.pop();
                }
            }
            else{                      // 栈顶为运算符
                if(isPriority(s,symbolTop)){     // 当前符号优先级大于栈顶符号优先级
                    symbolStack.push(s);
                }else{  // 当前符号优先级小于 等于 栈顶符号优先级
                    symbolTop = symbolStack.pop();
                    nPolandStack.add(symbolTop);
                    // 从符号栈是否为空判断处执行
                    symbolStackIsNotEmpty(s,symbolStack,nPolandStack);
                }
            }
        }
    }

    /**
     * 判断s的优先级是否大于symbolTop的优先级
     * @param s
     * @param symbolTop
     * @return 大于 1 小于等于 0
     */
    private static boolean isPriority(String s, String symbolTop) {
        boolean result = false;
        if(("*".equals(s) || "/".equals(s)) && ("+".equals(symbolTop) || "-".equals(symbolTop)))
            result = true;
        return false;
    }

    // 逆波兰表达式的计算
    private static void countNPoland(String nPolandStr) {
        final char[] nPolandArray = nPolandStr.toCharArray();
        LinkedStackDemo<String> stack = new LinkedStackDemo<>();    // 用来存储表达式
        for(char s:nPolandArray){
            if("exit".equals(s)){
                loop = false;
            }
            else{
                if(isNum(s+"")){                       // 如果是数字入栈
                    stack.push(s+"");
                }else{                              // 符号 计算结果并入栈
                    cout(stack,s+"");
                }
            }
        }
        if(!"exit".equals(nPolandStr)){

        }
            System.out.println("结果为:"+stack.pop());
    }

    private static void cout(LinkedStackDemo<String> stack, String s) {
        int result = 0;
        int a=Integer.valueOf(stack.pop());
        int b=Integer.valueOf(stack.pop());
        switch (s){
            case "+":
                result = a + b;
                break;
            case "-":
                result = b - a;
                break;
            case "*":
               result = a * b;
               break;
            case "/":
                result = b / a;
                break;
                default:
                    break;
        }
        stack.push(result+"");
    }

    // 是否为数字
    private static boolean isNum(String s) {
        char[] chars = s.toCharArray();
        boolean result = true;
        if(!s.matches("\\d+")){
            result = false;
            if(s.length()>1)
                throw new RuntimeException("输入有误");
        }
        return result;
    }
}
