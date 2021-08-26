package com.demo.reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * 反射
 */
public class Reflect {
    public static void main(String[] args) {
        FiledList<CountedInteger> list = new FiledList<>(CountedInteger.class);
        System.out.println(list.create(15));
    }
}
class CountedInteger{
    private static long counter;
    private final long id = counter ++;
    public String toString(){
        return Long.toString(id);
    }
}
class FiledList<T>{
    private Class<T> type;
    public FiledList(Class<T> type){
        this.type = type;
    }
    public List<T> create(int nElements){
        List<T> result = new ArrayList<>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}