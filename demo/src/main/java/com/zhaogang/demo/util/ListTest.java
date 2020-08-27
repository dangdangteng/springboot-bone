package com.zhaogang.demo.util;

import com.zhaogang.demo.entity.SimsStudent;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

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
    }
}
