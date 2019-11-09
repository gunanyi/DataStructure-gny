package main.java.datastructure.hashtab;

/**
 * 哈希表的简单实现
 */
public class HashTabDemo<E> {

    private LinkedData<E>[] linkedDataArr;
    int size;
    public HashTabDemo(int size){
        linkedDataArr = new LinkedData[size];
        this.size = size;
        // 需要初始化每一个数组元素，否则数组元素为null会报空指针异常
        for(int i=0 ; i<size ; i++){
            linkedDataArr[i] = new LinkedData<>();
        }
    }
    // 添加数据
    public void add(int id,E e){
        int cur = hash(id);         // 获取要插入的数组下标
        linkedDataArr[cur].add(id,e);
    }
    // 遍历数据
    public void list(){
        for(int i=0 ; i < size ;i++){
            if(null != linkedDataArr[i])
             linkedDataArr[i].list();
        }
    }
    // 根据id 查找数据
    public E get(int id){
        int cur = hash(id);
        E e = linkedDataArr[cur].find(id);
        if( null == e){
            System.out.println("没找到");
        }
        return e;
    }

    private int hash(int id) {
        return id % size;
    }

    // 链表
    private static class LinkedData<E>{
        int id;
        E e;
        LinkedData next;
        LinkedData head;
        public LinkedData(){

        }
        public LinkedData(int id , E e){
            this.e = e;
            this.id = id;
        }
        // 添加数据
        public void add(int id , E e){
            LinkedData data = new LinkedData(id,e);
            LinkedData temp = head;
            if(head == null){
                head = data;
            }else { // 添加到链尾
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = data;
            }
        }
        // 遍历链表
        public void list(){
            LinkedData temp = head;
            if(temp != null){
                while(temp!=null){
                    System.out.println("data:" + temp.e.toString());
                    temp = temp.next;
                }
            }else {
                System.out.println("链表为空");
            }
        }

        public E find(int id) {
            E result = null;
            LinkedData<E> temp = head;
            if(null != temp){
                while(temp != null){
                    if(temp.id == id){
                        result = temp.e;
                        break;
                    }
                }
            }
            return result;
        }
    }
}
