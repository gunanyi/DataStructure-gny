package main.java.datastructure.queue.fanzhuan;

import main.java.datastructure.queue.SignLinkedListDemo;

import javax.swing.*;
import java.util.LinkedList;

public class SignLinkedListTest {
    public static void main(String[] args) {

    }

    /*private void fanzhuan(SignLinkedListDemo linkedList){
        SignLinkedListDemo.LinkNode head = linkedList.getHead();
        SignLinkedListDemo.LinkNode temp = null;
        SignLinkedListDemo.LinkNode headTemp = head;
        temp = head.getNext();
        boolean flag = false;
        while(head.getNext().getNext()!=null){
            head.getNext().getNext().setNext(temp);
            temp = temp.getNext();
            head = head.getNext();
            flag  = true;
        }
        if(flag){
            headTemp.setNext(head);
        }

    }*/
}
