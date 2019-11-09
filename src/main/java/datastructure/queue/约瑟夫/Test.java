package main.java.datastructure.queue.约瑟夫;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        QueueH<Integer> queueH = new QueueH<>();
        queueH.add(1);
        queueH.add(2);
        queueH.add(3);
        //queueH.show();
        queueH.popAll(2);
        List<Integer> list = queueH.getList();
        for(Integer e:list){
            System.out.println(e);
        }
    }
}
