package main.java.datastructure.queue;

import main.java.datastructure.queue.model.Perpol;

import java.net.ServerSocket;

public class DoubleTest {
    public static void main(String[] args) {
        DoubleLinkedListDemo doubleLinkedListDemo = new DoubleLinkedListDemo();
        Perpol perpol = new Perpol(1,"顾南衣1号");
        Perpol perpol2 = new Perpol(2,"顾南衣2号");
        Perpol perpol3 = new Perpol(3,"顾南衣3号");
        doubleLinkedListDemo.addAndSort(perpol,1);
        /*doubleLinkedListDemo.addAndSort(perpol2,2);
        doubleLinkedListDemo.addAndSort(perpol3,3);
        Perpol perpol4 = new Perpol(3,"顾南衣4号");
        doubleLinkedListDemo.modfiy(perpol4,3);*/
        doubleLinkedListDemo.del(1);
        Perpol last = (Perpol)doubleLinkedListDemo.getLast();
        System.out.println("尾节点:" + last.toString());
        doubleLinkedListDemo.show();
    }
}
