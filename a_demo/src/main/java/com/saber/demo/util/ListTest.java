package com.saber.demo.util;

import java.lang.reflect.Array;

/**
 * @author baiyang
 * @date 2020/8/13
 */
public class ListTest<T> {

    //    FastList
    private final Class<?> clazz;
    private T[] elementData;
    private int size;

    public ListTest(Class<?> clazz, T[] elementData, int size) {
        this.clazz = clazz;
        this.elementData = elementData;
        this.size = size;
    }

    public ListTest(Class<?> clazz) {
        this.elementData = (T[]) Array.newInstance(clazz, 32);
        this.clazz = clazz;
    }

    public static void main(String[] args) {
//        ListTest<SimsStudent> a = new ListTest<>(SimsStudent.class);
//        Field[] declaredFields = SimsStudent.class.getDeclaredFields();
//        Field.setAccessible(declaredFields, true);
//        for (int i = 0; i < declaredFields.length; i++) {
//            System.out.println(declaredFields[i].getName());
//            declaredFields[i].getGenericType()
//        }
        System.out.println(13 & 17);
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b);
        System.out.println(100 == 100);
    }
}
