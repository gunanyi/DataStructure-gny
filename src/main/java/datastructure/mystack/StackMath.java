package main.java.datastructure.mystack;

import java.util.Scanner;

/**
 * 表达式计算
 */
public class StackMath {
    public static void main(String[] args) {
        int a=0;
        int b=0;
        Character fh = null;
        int num = 0;
        String curNum = "";         // 处理多位数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要计算的表达式");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        // 两个栈，数栈和符号栈
        LinkedStackDemo<Integer> stackNum = new LinkedStackDemo<>();
        LinkedStackDemo<Character> stackFH = new LinkedStackDemo<>();
        for (int i=0;i<chars.length;i++) {
            if (Character.isDigit(chars[i])) {// 数字
                curNum+=chars[i];
                if(i!=chars.length-1 && Character.isDigit(chars[i+1])){
                    continue;
                }
                stackNum.push(Integer.parseInt(curNum));
                curNum = "";
            } else {                      // 符号
                if (stackFH.isEmpty()) {  // 符号栈为空直接放入
                    stackFH.push(chars[i]);
                } else if (priority(chars[i], stackFH)) { //c 的优先级大于 c1的优先级
                    stackFH.push(chars[i]);
                }else if(!priority(chars[i],stackFH)){     // c的优先级小于等于 c1的优先级
                    count(stackNum,stackFH);  // 计算值并存入数栈
                    while (!stackFH.isEmpty()&&!priority(chars[i],stackFH)){
                        count(stackNum,stackFH);
                    }
                    stackFH.push(chars[i]);                // 存入符号
                }
            }
        }
        // 如果符号栈不为空，计算
        while (!stackFH.isEmpty()){
            count(stackNum,stackFH);
        }
        System.out.println("结果为:"+stackNum.pop());
    }
    // 计算数并存入数栈
    private static void count(LinkedStackDemo<Integer> stackNum,LinkedStackDemo<Character> stackFH) {
        int a = stackNum.pop();
        int b = stackNum.pop();
        Character fh = stackFH.pop();
        int num = count(b,a,fh);
        stackNum.push(num);
    }

    // 计算
    private static int count(int a, int b, Character fh) {
        int result = 0;
        switch (fh){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
                default:
                    break;
        }
        return result;
    }

    // 判断两个符号的优先级  c的大于栈中第一个符号优先级 返回 true
    private static boolean priority(char c, LinkedStackDemo<Character> stackFH) {
        boolean result = false;
        char c1 = stackFH.pop();
        stackFH.push(c1);
        if((c=='*' || c=='/') && (c1=='+'||c1=='-'))
            result = true;
        return result;
    }
}


