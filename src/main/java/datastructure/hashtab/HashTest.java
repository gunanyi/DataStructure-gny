package main.java.datastructure.hashtab;

import main.java.datastructure.hashtab.model.Emp;

public class HashTest {
    public static void main(String[] args) {
        HashTabDemo<Emp> hashTabDemo = new HashTabDemo<Emp>(16);
        Emp emp = new Emp(0,"顾南衣1号");
        Emp emp1 = new Emp(1,"顾南衣2号");
        Emp emp2 = new Emp(16,"顾南衣3号");
        hashTabDemo.add(emp.getId(),emp);
        hashTabDemo.add(emp1.getId(),emp1);
        hashTabDemo.add(emp2.getId(),emp2);
        hashTabDemo.list();
        System.out.println(hashTabDemo.get(0).toString());
    }
}
