package com.loubi.java.designmodel.singleton;

/**
 * @author baiyang
 * @date 2020/12/18
 * 双重校验锁
 */
public class SingleDemo2 {

    private volatile static SingleDemo2 singleDemo2;

    public SingleDemo2() {
    }

    public static SingleDemo2 getInstance(){
        if (singleDemo2 == null){
            synchronized (SingleDemo2.class){
                if (singleDemo2 == null){
                    singleDemo2 = new SingleDemo2();
                }
            }
        }
        return singleDemo2;
    }
}
