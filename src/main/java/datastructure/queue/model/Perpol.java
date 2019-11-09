package main.java.datastructure.queue.model;

public class Perpol {
    private Integer sort;
    private String name;

    public Perpol(int sort,String name){
        this.sort = sort;
        this.name = name;
    }
    public Perpol(){

    }

    @Override
    public String toString() {
        return "Perpol{" +
                "sort=" + sort +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
